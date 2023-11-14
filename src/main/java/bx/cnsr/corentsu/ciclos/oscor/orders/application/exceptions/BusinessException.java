package bx.cnsr.corentsu.ciclos.oscor.orders.application.exceptions;

public class BusinessException extends GenericException {
    public BusinessException(ExceptionCodes exceptionCode, String logFormat, String... logParams) {
        super(exceptionCode, logFormat, logParams);
    }

    public BusinessException(ExceptionCodes exceptionCode, String logFormat) {
        super(exceptionCode, logFormat);
    }

}
