package com.asterai.zmina.engine;

import com.asterai.zmina.organism.Organism;

import java.util.ArrayList;
import java.util.List;

public class ZminaEngine {

    /**
     * List of current organisms that survived.
     */
    private List<Organism> organismList = new ArrayList<>();

    public void run (int input, int expectedResult) {
      System.out.println(String.format("Run engine - input: %d, expected: %d", input, expectedResult));
      for (var organism: organismList) {
          organism.perform(input);
      }
    }

    public void addOrganism(Organism organism) {
        organismList.add(organism);
    }

    public List<Organism> getOrganismList() {
        return organismList;
    }

}