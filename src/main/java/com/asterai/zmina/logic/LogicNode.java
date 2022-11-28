package com.asterai.zmina.logic;

import java.util.List;

public interface LogicNode {
//    void setType(Nodes type);
    Nodes getType();

    void addSubNode(NodeAbstract node);

    List<LogicNode> getChildren();

    boolean isPrimitive();
}
