package com.asterai.zmina.parser;

import com.asterai.zmina.logic.MindsetNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Parser {
    public Map<String, MindsetNode> parseFile(String fileName) {
        Map<String, MindsetNode> result = new HashMap<>();
        String fileContent = """
                 
                interface DataFromUser {
                    varFromUser = 0
                }
                
                interface EquationMindResult {
                    result = 0
                }
                
                //
                // mind for particular entity (equation)
                // resolves equation like 3 + X = 11
                // Every mind model should contain at least 2 interfaces (for input and output)
                // {input} DataFromUser
                // {output} EquationMindResult
                mind Equation DataFromUser -> EquationMindResult {
                    const unknownXValue = 8
                                
                    main {
                        out.result = in.varFromUser + unknownXValue
                    }
                }
                """;
        System.out.println(fileContent);
        List<Token> tokens = tokenize(fileContent);
        return result;
    }

    private List<Token> tokenize(String content) {
        List<Token> rawTokens = new ArrayList<>();
        int cursor = 0;

        while (cursor < content.length()) {
            char currentChar = content.charAt(cursor);
            ++cursor;

            switch (currentChar) {
                case ' ' -> {
                    continue;
                }
                case '\n' -> {
                    rawTokens.add(new Token(TokenType.NewLine));
                }
                default -> {
                    int tokenEnd = findTokenEndPos(content, cursor - 1);
                    String token = content.substring(cursor - 1, tokenEnd);
                    if (token.length() >= 2 && token.charAt(0) == '/' && token.charAt(1) == '/') {
                        rawTokens.add(new Token(TokenType.CommentToken, token));
                    } else {
                        rawTokens.add(new Token(TokenType.StringToken, token));
                    }

                    cursor = tokenEnd;
                    System.out.println(tokenEnd);
                }
            }

        }

        return rawTokens;
    }

    private int findTokenEndPos(String content, int startFrom) {
        int len = content.length();
        int cursor = startFrom;

        boolean isComment = false;
        for (; cursor < len; ++cursor) {
            char c = content.charAt(cursor);
            if (c == '/' && cursor + 1  < len &&  content.charAt(cursor + 1) == '/') {
                isComment = true;
                ++cursor;
            }
            if (c == '\n' || (!isComment && c == ' ')) {
                return cursor;
            }
        }

        return cursor;
    }
}
