package org.ylan.lejingling.common.convention.enums;

import org.ylan.lejingling.common.convention.errorcode.IErrorCode;

/**
 * @author ylan
 */

public enum UserErrorCodeEnum implements IErrorCode {

    USER_LOGIN_ERROR("B000201","用户登录失败,用户名或密码错误"),
    USER_REPEAT_LOGIN_ERROR("B000202","用户重复登录错误");

    private final String code;

    private final String message;

    UserErrorCodeEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String code() {
        return code;
    }

    @Override
    public String message() {
        return message;
    }
}