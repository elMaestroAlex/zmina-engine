package com.asterai.zmina.logic;

public class ReferenceInputNode extends NodeAbstract {
    private int value = 0;
    public ReferenceInputNode() {
        type = Nodes.REFERENCE_INPUT;
    }

    public void setValue(int value) {
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
