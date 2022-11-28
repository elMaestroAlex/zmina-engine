package com.asterai.zmina.processor;

import com.asterai.zmina.logic.ConstNode;
import com.asterai.zmina.logic.LogicNode;
import com.asterai.zmina.logic.ReferenceInputNode;

public class BaseLogicProcessor implements LogicProcessor {

    @Override
    public void run(LogicNode logic) {
        // return INPUT (3) + CONST (8)
        System.out.println("Proceed logic");
        System.out.println(logic);
        runInstruction(logic);
    }

    private void runInstruction(LogicNode node) {
        LogicNode contextNode = node;
        switch (node.getType()) {
            case RETURN -> {
                System.out.println("Proceed 'RETRUN' logic");
                contextNode = contextNode.getChildren().get(0);
                runExpression(contextNode);
            }
        }
    }

    private int runExpression(LogicNode node) {
        switch (node.getType()) {
            case PLUS -> {
                LogicNode nodeLeft = node.getChildren().get(0);
                LogicNode nodeRight = node.getChildren().get(1);
                int valLeft;
                int valRight;
                if (nodeLeft.isPrimitive()) {
                    valLeft = processPrimitive(nodeLeft);
                } else {
                    valLeft = runExpression(nodeLeft);
                }

                if (nodeRight.isPrimitive()) {
                    valRight = processPrimitive(nodeRight);
                } else {
                    valRight = runExpression(nodeRight);
                }
                System.out.print("Proceed 'PLUS' logic result = ");
                System.out.println(valLeft + valRight);
                return valLeft + valRight;
            }
        }

        return 0;
    }

    private int processPrimitive(LogicNode node) {
        switch (node.getType()) {
            case CONST -> {
                ConstNode cNode = (ConstNode) node;
                return cNode.getValue();
            }
            case REFERENCE_INPUT -> {
                ReferenceInputNode refNode = (ReferenceInputNode) node;
                return refNode.getValue();
            }
        }

        return 0;
    }
}
