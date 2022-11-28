package com.asterai.zmina.logic;

public class ConstNode extends NodeAbstract {
    private int value = 0;
    public ConstNode(int value) {
        type = Nodes.CONST;
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean isPrimitive() {
        return true;
    }
}
