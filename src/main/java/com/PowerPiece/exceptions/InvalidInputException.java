package com.PowerPiece.exceptions;

import java.io.Serial;

public class InvalidInputException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 1L;

    InvalidInputException() {}
    public InvalidInputException(String message) {
        super(message);
    }
}
