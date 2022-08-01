package com.asterai.zmina.program.logic;

public interface LogicNode {
//    void setType(Nodes type);
    Nodes getType();

    void addSubNode(NodeAbstract node);

}
