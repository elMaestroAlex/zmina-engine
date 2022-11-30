package com.asterai.zmina.organism;

import com.asterai.zmina.logic.*;
import com.asterai.zmina.processor.BaseLogicProcessor;
import com.asterai.zmina.processor.LogicProcessor;

import java.util.Map;

public class BaseOrganism implements Organism {

    private int state = 0;
    private String name = "";

    private LogicNode program;

    private final LogicProcessor processor = new BaseLogicProcessor();


    public BaseOrganism(String name) {
        this.name = name;
        initLogic();
    }

    @Override
    public int getState() {
        return state;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void perform(Map<String, Integer> inputModel) {
        processor.run(program, inputModel);
//        state = program.run(input);
    }

    private void initLogic() {
        // return INPUT + CONST
        program = new ReturnNode();
        var plusNode = new PlusNode();

        plusNode.addSubNode(new ReferenceInputNode("input"));
        plusNode.addSubNode(new ConstNode(8));

        program.addSubNode(plusNode);

        System.out.printf("Logic for '%s' has been init\n", name);
    }
}
