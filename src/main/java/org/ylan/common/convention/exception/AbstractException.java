package org.ylan.common.convention.exception;

import lombok.Getter;
import org.springframework.util.StringUtils;
import org.ylan.common.convention.errorcode.IErrorCode;

import java.util.Optional;

/**
 * @author ylan
 */

@Getter
public abstract class AbstractException extends RuntimeException {

    /**
     * 异常Code值
     */
    public final String errorCode;

    /**
     * 异常Message值
     */
    public final String errorMessage;

    public AbstractException(String message, Throwable throwable, IErrorCode errorCode) {
        // 构建异常信息
        super(message, throwable);
        // 设置Code值
        this.errorCode = errorCode.code();
        // 设置Message值,message不为空时优先使用message,否则使用errorCode的message
        this.errorMessage = Optional.ofNullable(StringUtils.hasLength(message) ? message : null).orElse(errorCode.message());
    }
}