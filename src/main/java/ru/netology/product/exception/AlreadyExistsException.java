package ru.netology.product.exception;

public class AlreadyExistsException extends RuntimeException {

    public AlreadyExistsException(String message) {

        super(message);
    }
}
