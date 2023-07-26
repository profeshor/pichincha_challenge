package com.pichincha.test.pichincha.exceptions;

public class AmountOutOfRange extends Exception {

    public AmountOutOfRange(String message) {
        super(message);
    }

    // Opcionalmente puedes añadir un constructor que acepte una causa:
    public AmountOutOfRange(String message, Throwable cause) {
        super(message, cause);
    }
}