package org.ylan.lejingling.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.alibaba.fastjson2.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.ylan.lejingling.common.convention.exception.ClientException;
import org.ylan.lejingling.mapper.UserMapper;
import org.ylan.lejingling.model.dto.UserLoginReqDTO;
import org.ylan.lejingling.model.dto.UserLoginRespDTO;
import org.ylan.lejingling.model.entity.UserEntity;
import org.ylan.lejingling.service.UserService;

import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import static org.ylan.lejingling.common.constant.LOGIN_PREFIX;
import static org.ylan.lejingling.common.convention.enums.UserErrorCodeEnum.USER_LOGIN_ERROR;

/**
 * @author ylan
 */

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl extends ServiceImpl<UserMapper, UserEntity> implements UserService {

    /**
     * StringRedisTemplate 操作redis
     */
    private final StringRedisTemplate stringRedisTemplate;

    @Override
    public UserLoginRespDTO login(UserLoginReqDTO requestParam) {

        // 查询Redis中存储的用户信息，如果用户重复登陆则直接返回用户Token，并对token进行续约30分钟
        Map<Object ,Object> hasLoginMap = stringRedisTemplate.opsForHash().entries(LOGIN_PREFIX + requestParam.getPhoneNumber());
        if (CollUtil.isNotEmpty(hasLoginMap)) {
            stringRedisTemplate.expire(LOGIN_PREFIX + requestParam.getPhoneNumber(), 30L, TimeUnit.MINUTES);
            String token = hasLoginMap.keySet().stream()
                    .findFirst()
                    .map(Object::toString)
                    .orElseThrow(() -> new ClientException("用户登录错误"));
            return new UserLoginRespDTO(token);
        }

        // 查询数据库判断用户是否可以登陆
        LambdaQueryWrapper<UserEntity> queryWrapper = Wrappers.lambdaQuery(UserEntity.class)
                .eq(UserEntity::getPhoneNumber, requestParam.getPhoneNumber())
                .eq(UserEntity::getPassword, requestParam.getPassword());
        UserEntity user = baseMapper.selectOne(queryWrapper);
        if (Objects.isNull(user)){
            // 用户登录失败,用户名或密码错误
            throw new ClientException(USER_LOGIN_ERROR);
        }

        // 生成token
        String token = UUID.randomUUID().toString();

        // 存入redis
        stringRedisTemplate.opsForHash().put(LOGIN_PREFIX + requestParam.getPhoneNumber(), token, JSON.toJSONString(user));
        stringRedisTemplate.expire(LOGIN_PREFIX + requestParam.getPhoneNumber(), 30L, TimeUnit.MINUTES);

        return UserLoginRespDTO.builder().token(token).build();
    }

}