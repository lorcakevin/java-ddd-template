package bx.cnsr.corentsu.ciclos.oscor.orders.application.exceptions;


import lombok.Getter;

@Getter
public class GenericException extends RuntimeException {

    private static final long serialVersionUID = -5991880697670935342L;
    private final ExceptionCodes exceptionCode;
    private final String logFormat;
    private final String[] logParams;

    public GenericException(ExceptionCodes exceptionCode, String logFormat, String... logParams) {
        super(String.format(logFormat,
                (Object[]) logParams));

        this.exceptionCode = exceptionCode;
        this.logFormat = logFormat;
        this.logParams = logParams;
    }

    public GenericException(ExceptionCodes exceptionCode, Throwable throwable, String logFormat, String... logParams) {
        super(throwable);

        this.exceptionCode = exceptionCode;
        this.logFormat = logFormat;
        this.logParams = logParams;

    }

}
