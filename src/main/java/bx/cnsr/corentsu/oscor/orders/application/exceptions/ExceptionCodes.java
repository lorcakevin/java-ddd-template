package bx.cnsr.corentsu.oscor.orders.application.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public enum ExceptionCodes {
    APP_0001("99999", "No se pudo ejecutar la operación."),

    BIZ_001("001", "Se presentó un problema al intentar realizar la cubicación."),
    BIZ_002("002", "No se pudo obtener información de la cubicación.");

    private final String code;
    private final String message;

    public static String getMessageByCode(String code) {
        for (ExceptionCodes exceptionCode : values()) {
            if (exceptionCode.code.equals(code)) {
                return exceptionCode.message;
            }
        }
        return null;
    }

    public static ExceptionCodes getExceptionCodeByCode(String code) {
        for (ExceptionCodes exceptionCode : values()) {
            if (exceptionCode.code.equals(code)) {
                return exceptionCode;
            }
        }
        return ExceptionCodes.APP_0001;
    }

}
