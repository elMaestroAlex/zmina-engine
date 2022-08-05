package com.asterai.zmina.vm;

import com.asterai.zmina.logic.LogicNode;

public class BaseVirtualMachine implements VirtualMachine {

    @Override
    public void run(LogicNode logic) {
        System.out.println("Proceed logic");
        System.out.println(logic);
    }
}
