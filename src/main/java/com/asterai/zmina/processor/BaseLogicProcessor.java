package com.asterai.zmina.processor;

import com.asterai.zmina.logic.ConstNode;
import com.asterai.zmina.logic.LogicNode;
import com.asterai.zmina.logic.ReferenceInputNode;

import java.util.Map;

public class BaseLogicProcessor implements LogicProcessor {

    private Map<String, Integer> inputModel;

    @Override
    public void run(LogicNode logic, Map<String, Integer> inputModel) {
        this.inputModel = inputModel;
        // return INPUT (3) + CONST (8)
        System.out.println("Proceed logic");
        int resultOfRun  = processInstruction(logic);
        System.out.print("Result of execution : ");
        System.out.println(resultOfRun);
    }

    private int processInstruction(LogicNode node) {
        LogicNode contextNode = node;
        switch (node.getType()) {
            case RETURN -> {
                contextNode = contextNode.getChildren().get(0);
                return processSingleNode(contextNode);
            }
        }

        return 0;
    }

    private int processSingleNode(LogicNode node) {
        int val;
        if (node.isPrimitive()) {
            val = processPrimitive(node);
        } else {
            val = processExpression(node);
        }

        return val;
    }

    private int processExpression(LogicNode node) {
        switch (node.getType()) {
            case PLUS -> {
                int valLeft = processSingleNode(node.getChildren().get(0));
                int valRight = processSingleNode(node.getChildren().get(1));

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
                return inputModel.get(refNode.getNodeName());
            }
        }

        return 0;
    }
}
