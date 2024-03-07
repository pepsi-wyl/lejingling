package org.ylan.model.dto.req;

import lombok.Data;

/**
 * @author ylan
 */

@Data
public class UserLoginReqDTO {

    /**
     * 手机号
     */
    private String phoneNumber;

    /**
     * 密码
     */
    private String password;
}