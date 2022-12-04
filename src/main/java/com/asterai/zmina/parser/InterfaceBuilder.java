package com.asterai.zmina.parser;

import com.asterai.zmina.logic.MindInterfaceImp;
import com.asterai.zmina.logic.MindsetNode;
import com.asterai.zmina.logic.ReferenceInterfaceNode;

import java.util.List;
import java.util.Map;

public class InterfaceBuilder extends CommonBuilder implements MindsetElementBuilder {
    @Override
    public int build(List<Token> tokens, Map<String, MindsetNode> mindSet, int cursorPos) {
        Token currentToken = tokens.get(cursorPos);
        if (currentToken.getType() != TokenType.InterfaceToken) {
            throw new UnexpectedTokenError("Token is not Interface");
        }

        // interface name
        currentToken = tokens.get(++cursorPos);
        String interfaceName = currentToken.getContent();
        MindInterfaceImp interfaceNode = new MindInterfaceImp(interfaceName);
        if (mindSet.containsKey(interfaceName)) {
            throw new UnexpectedTokenError(String.format("Element with name \"%s\" already declared.", interfaceName));
        }
        mindSet.put(interfaceName, interfaceNode);


        currentToken = tokens.get(++cursorPos);
        if (currentToken.getType() != TokenType.BlockStart) {
            throw new UnexpectedTokenError(String.format("Unexpected token \"%s\", expected \"{\".", currentToken.getContent()));
        }

        ReferenceInterfaceNode currentInterfaceField = null;
        Token prevToken;
        do {
            prevToken = currentToken;
            currentToken = tokens.get(++cursorPos);

            switch (currentToken.getType()) {
                case StringToken -> {
                    if (prevToken.getType() == TokenType.Equals &&  currentInterfaceField != null) {
                        currentInterfaceField.setValue(Integer.parseInt(currentToken.getContent()));
                    } else {
                        currentInterfaceField = new ReferenceInterfaceNode(currentToken.getContent());
                        interfaceNode.addSubNode(currentInterfaceField);
                    }
                }
                case NewLine -> {
                    currentInterfaceField = null;
                }
            }
        } while (currentToken.getType() != TokenType.BlockEnd && cursorPos < tokens.size());

        return cursorPos;
    }
}
