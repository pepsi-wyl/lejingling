package org.ylan.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.ylan.model.dto.req.UserLoginReqDTO;
import org.ylan.model.entity.UserEntity;

/**
 * @author ylan
 */

@Mapper
public interface UserMapper extends BaseMapper<UserEntity> {

    /**
     * 根据手机号和密码查询用户
     */
    UserEntity selectUserByPhoneNumberAndPassword(@Param("param") UserLoginReqDTO requestParam);
}