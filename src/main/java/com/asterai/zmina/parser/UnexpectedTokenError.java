package com.asterai.zmina.parser;

public class UnexpectedTokenError extends Error {

    public UnexpectedTokenError() {
        super();
    }

    public UnexpectedTokenError(String message) {
        super(message);
    }
}
