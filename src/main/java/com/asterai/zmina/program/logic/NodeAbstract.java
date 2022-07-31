package com.asterai.zmina.program.logic;

import java.util.ArrayList;
import java.util.List;

abstract public class NodeAbstract implements LogicNode {
    protected Nodes type = Nodes.PLUS;

    protected List<Integer> params = new ArrayList<Integer>();

    @Override
    public Nodes getType() {
        return type;
    }

    @Override
    public void addParam(int param) {
        params.add(param);
    }

}
