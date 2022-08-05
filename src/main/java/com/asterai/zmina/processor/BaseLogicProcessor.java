package com.asterai.zmina.processor;

import com.asterai.zmina.logic.LogicNode;

public class BaseLogicProcessor implements LogicProcessor {

    @Override
    public void run(LogicNode logic) {
        System.out.println("Proceed logic");
        System.out.println(logic);
    }
}
