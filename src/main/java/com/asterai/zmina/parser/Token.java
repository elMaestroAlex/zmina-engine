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

        recognizeSpecialToken();
    }

    public TokenType getType() {
        return type;
    }
    public String getContent() {
        return content;
    }

    private void recognizeSpecialToken() {
        if (type != TokenType.StringToken) {
            return;
        }

        switch (content) {
            case "interface" -> type = TokenType.InterfaceToken;
            case "mind" -> type = TokenType.MindModelToken;
            case "{" -> type = TokenType.BlockStart;
            case "}" -> type = TokenType.BlockEnd;
            case "=" -> type = TokenType.Equals;
        }
    }
}
