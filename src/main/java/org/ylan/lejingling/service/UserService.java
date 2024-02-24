package org.ylan.lejingling.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.ylan.lejingling.model.dto.UserLoginReqDTO;
import org.ylan.lejingling.model.dto.UserLoginRespDTO;
import org.ylan.lejingling.model.entity.UserEntity;

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