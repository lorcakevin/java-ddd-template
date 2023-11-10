package bx.cnsr.corentsu.oscor.orders.application.exceptions;

public class BusinessException extends GenericException {
    public BusinessException(ExceptionCodes exceptionCode, String logFormat, String... logParams) {
        super(exceptionCode, logFormat, logParams);
    }

    public BusinessException(ExceptionCodes exceptionCode, String logFormat) {
        super(exceptionCode, logFormat);
    }

}
