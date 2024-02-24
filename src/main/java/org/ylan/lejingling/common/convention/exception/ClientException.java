package org.ylan.lejingling.common.convention.exception;


import org.ylan.lejingling.common.convention.enums.BaseErrorCodeEnum;
import org.ylan.lejingling.common.convention.errorcode.IErrorCode;

/**
 * @author ylan
 */

public class ClientException extends AbstractException {

    public ClientException(String message) {
        this(message, null, BaseErrorCodeEnum.CLIENT_ERROR);
    }

    public ClientException(IErrorCode errorCode) {
        this(null, null, errorCode);
    }

    public ClientException(String message, IErrorCode errorCode) {
        this(message, null, errorCode);
    }

    public ClientException(String message, Throwable throwable, IErrorCode errorCode) {
        super(message, throwable, errorCode);
    }

    @Override
    public String toString() {
        return "ClientException{" +
                "code='" + errorCode + "'," +
                "message='" + errorMessage + "'" +
                '}';
    }
}