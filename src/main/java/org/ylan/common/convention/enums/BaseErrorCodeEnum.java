package org.ylan.common.convention.enums;

import org.ylan.common.convention.errorcode.IErrorCode;

/**
 * @author ylan
 */

public enum BaseErrorCodeEnum implements IErrorCode {

    // ========== 一级宏观错误码 客户端错误 ==========
    CLIENT_ERROR("A000001", "用户端错误"),
    // ========== 一级宏观错误码 系统执行出错 ==========
    SERVICE_ERROR("B000001", "系统执行出错");

    private final String code;

    private final String message;

    BaseErrorCodeEnum(String code, String message) {
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