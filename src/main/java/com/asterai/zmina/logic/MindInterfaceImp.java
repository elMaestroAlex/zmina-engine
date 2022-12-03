package com.asterai.zmina.logic;

import java.util.Map;

public class MindInterfaceImp extends NodeMindsetAbstract implements MindInterface {

    public MindInterfaceImp(String name) {
        this.name = name;
        type = Nodes.MIND_INTERFACE;
    }
    @Override
    public Map<String, Integer> getInterfaceModel() {
        return null;
    }

}
