package com.asterai.zmina.logic;

import java.util.Map;

public class MindModelImp extends NodeMindsetAbstract implements MindModel {

    public MindModelImp(String name) {
        this.name = name;
        type = Nodes.MIND_MODEL;
    }


    @Override
    public MindInterface getInInterface() {
        return null;
    }

    @Override
    public MindInterface getOutInterface() {
        return null;
    }
}
