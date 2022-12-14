package com.asterai.zmina.logic;

import java.util.ArrayList;
import java.util.List;

abstract public class NodeAbstract implements LogicNode {
    protected Nodes type;

    protected List<LogicNode> children = new ArrayList<>();

    @Override
    public Nodes getType() {
        return type;
    }

    @Override
    public void addSubNode(NodeAbstract node) {
        children.add(node);
    }

    @Override
    public List<LogicNode> getChildren() {
        return children;
    }
    @Override
    public boolean isPrimitive() {
        return false;
    }

}
