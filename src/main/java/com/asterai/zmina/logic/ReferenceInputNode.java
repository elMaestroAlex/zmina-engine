package com.asterai.zmina.logic;

public class ReferenceInputNode extends NodeAbstract {
    private int value = 0;
    private String nodeName;

    public ReferenceInputNode(String nodeName) {
        type = Nodes.REFERENCE_INPUT;
        this.nodeName = nodeName;
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

    public String getNodeName() {
        return nodeName;
    }
}
