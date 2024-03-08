package org.ylan.common.convention.enums;

import org.ylan.common.convention.errorcode.IErrorCode;

/**
 * @author ylan
 */

public enum UserErrorCodeEnum implements IErrorCode {

    USER_LOGIN_ERROR("A000201","用户登录失败,用户名或密码错误"),
    USER_REPEAT_LOGIN_ERROR("A000202","用户重复登录错误"),
    USER_LOGIN_PARAM_ERROR("A000203","用户登录参数错误");

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