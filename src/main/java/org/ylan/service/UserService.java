package org.ylan.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.ylan.model.dto.req.UserLoginReqDTO;
import org.ylan.model.dto.resp.UserLoginRespDTO;
import org.ylan.model.entity.UserEntity;

/**
 * @author ylan
 */

public interface UserService extends IService<UserEntity> {

    /**
     * 用户登录
     *
     * @param requestParam 用户登录请求参数
     * @return 用户登录返回参数 Token
     */
    UserLoginRespDTO login(UserLoginReqDTO requestParam);
}