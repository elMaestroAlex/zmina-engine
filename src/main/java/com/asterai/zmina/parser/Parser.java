package com.asterai.zmina.parser;

import com.asterai.zmina.logic.MindsetNode;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Parser {

    MindsetElementBuilder interfaceBuilder = new InterfaceBuilder();
    MindsetElementBuilder mindsetElementBuilder = new MindModelBuilder();

    public Map<String, MindsetNode> parseFile(String fileName) {
        Map<String, MindsetNode> result = new HashMap<>();
        String fileContent = getFileContent(fileName);

        List<Token> tokens = tokenize(fileContent);
        buildMindSet(tokens, result);
        return result;
    }

    private void buildMindSet(List<Token> tokens, Map<String, MindsetNode> mindSet) {
        int cursor = 0;
        while (cursor < tokens.size()) {
            Token token = tokens.get(cursor);
            switch (token.getType()) {
                case InterfaceToken -> {
                    cursor = interfaceBuilder.build(tokens, mindSet, cursor);
                }
              //  case MindModelToken -> {
                //    cursor = mindsetElementBuilder.build(tokens, mindSet, cursor);
               // }
                default -> ++cursor;
            }
        }
        System.out.println();
    }

    private String getFileContent(String fileName) {
        FileReader reader;
        try {
            reader = new FileReader(fileName);
            File file = new File(fileName);
            char[] c = new char[(int) file.length()];
            reader.read(c);

            return new String(c);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
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
