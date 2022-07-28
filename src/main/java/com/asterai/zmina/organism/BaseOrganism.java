package com.asterai.zmina.organism;

public class BaseOrganism implements Organism {

    private int state = 0;

    @Override
    public int getState() {
        return state;
    }

    @Override
    public void perform(int input) {
        System.out.print("Perform organize value = ");
        System.out.print(input);
        System.out.print("\n");
    }
}
