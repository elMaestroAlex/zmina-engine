package com.asterai.zmina.parser;

public class Token {
    private TokenType type;
    private String content;

    public Token(TokenType type) {
        this.type = type;
    }

    public Token(TokenType type, String content) {
        this.type = type;
        this.content = content;
    }

    public TokenType getType() {
        return type;
    }
}
