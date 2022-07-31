package com.asterai.zmina.organism;

import com.asterai.zmina.program.BaseProgram;
import com.asterai.zmina.program.Program;

public class BaseOrganism implements Organism {

    private int state = 0;
    private String name = "";

    private Program program = new BaseProgram();

    public BaseOrganism(String name) {
        this.name = name;
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
    public void perform(int input) {
        state = program.run(input);
    }
}
