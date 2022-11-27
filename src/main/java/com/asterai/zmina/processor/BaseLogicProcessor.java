package com.asterai.zmina.processor;

import com.asterai.zmina.logic.LogicNode;

public class BaseLogicProcessor implements LogicProcessor {

    @Override
    public void run(LogicNode logic) {
        // return INPUT (3) + CONST (8)
        System.out.println("Proceed logic");
        System.out.println(logic);
    }


//    private void runE xpression(LogicNode node) {
//        switch (node.getType()) {
//            case RETURN -> {
//                runExpression()
//            }
//        }
//    }

}
