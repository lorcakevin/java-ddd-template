package bx.cnsr.corentsu.oscor.orders.application.exceptions;

public class ApplicationException extends GenericException {
    public ApplicationException(ExceptionCodes exceptionCode, String logFormat, String... logParams) {
        super(exceptionCode, logFormat, logParams);
    }

    public ApplicationException(ExceptionCodes exceptionCode, Throwable ex, String logFormat) {
        super(exceptionCode, ex, logFormat);
    }
    public ApplicationException(ExceptionCodes exceptionCode, Throwable ex, String logFormat, String... logParams) {
        super(exceptionCode, ex, logFormat, logParams);
    }
}
