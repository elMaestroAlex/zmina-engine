package com.asterai.zmina.parser;

import com.asterai.zmina.logic.MindsetNode;

import java.util.List;
import java.util.Map;

public class MindModelBuilder extends CommonBuilder implements MindsetElementBuilder {
    @Override
    public int build(List<Token> tokens, Map<String, MindsetNode> mindSet, int cursorPos) {
        Token currentToken = tokens.get(cursorPos);
        if (currentToken.getType() != TokenType.MindModelToken) {
            throw new UnexpectedTokenError("Token is not Mind model");
        }


        return cursorPos;
    }
}
