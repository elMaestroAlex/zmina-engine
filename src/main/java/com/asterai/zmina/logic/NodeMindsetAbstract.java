package com.asterai.zmina.logic;

abstract public class NodeMindsetAbstract extends NodeAbstract implements MindsetNode {

    protected String name = "";
    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean isPrimitive() {
        return false;
    }

}
