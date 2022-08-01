package com.asterai.zmina.program.logic;

import java.util.ArrayList;
import java.util.List;

abstract public class NodeAbstract implements LogicNode {
    protected Nodes type;

    protected List<NodeAbstract> children = new ArrayList<>();

    @Override
    public Nodes getType() {
        return type;
    }

    @Override
    public void addSubNode(NodeAbstract node) {
        children.add(node);
    }

}
