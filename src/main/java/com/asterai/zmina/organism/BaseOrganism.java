package com.asterai.zmina.organism;

public class BaseOrganism implements Organism {

    private int state = 0;
    private String name = "";

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
        System.out.print("Perform organize value = ");
        System.out.print(input);
        System.out.print("\n");
    }
}
