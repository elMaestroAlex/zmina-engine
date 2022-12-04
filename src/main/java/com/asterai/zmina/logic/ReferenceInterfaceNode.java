package com.asterai.zmina.logic;

public class ReferenceInterfaceNode extends NodeAbstract {
    private int value = 0;
    private String interfaceFieldName;

    public ReferenceInterfaceNode(String interfaceFieldName) {
        type = Nodes.REFERENCE_INTERFACE_FIELD;
        this.interfaceFieldName = interfaceFieldName;
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

    public String getInterfaceFieldName() {
        return interfaceFieldName;
    }
}
