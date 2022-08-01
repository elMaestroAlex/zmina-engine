package com.asterai.zmina.program;

import com.asterai.zmina.program.logic.*;

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
        // return INPUT + CONST
        var returnNode = new ReturnNode();
        var plusNode = new PlusNode();

        plusNode.addSubNode(new ReferenceInputNode());
        plusNode.addSubNode(new ConstNode());

        returnNode.addSubNode(plusNode);
        logic.add(returnNode);

        System.out.println("Logic has been init");
    }

}
