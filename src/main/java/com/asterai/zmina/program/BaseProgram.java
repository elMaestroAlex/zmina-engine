package com.asterai.zmina.program;

import com.asterai.zmina.program.logic.PlusNode;
import com.asterai.zmina.program.logic.LogicNode;

import java.util.ArrayList;
import java.util.List;

public class BaseProgram implements  Program {


    protected List<LogicNode> logic = new ArrayList<>();

    public BaseProgram() {
        initLogic();
    }

    @Override
    public int run(int input) {

        System.out.print("Perform organism value = ");
        System.out.print(input);
        System.out.print("\n");

        return input + 3;
    }

    private void initLogic() {
//        var plusNode = new PlusNode();
//        plusNode.addParam();
        logic.add(new PlusNode());
    }
}
