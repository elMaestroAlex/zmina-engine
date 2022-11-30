package com.asterai.zmina.engine;

import com.asterai.zmina.organism.Organism;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ZminaEngine {


    /**
     * List of current organisms that survived.
     */
    private final List<Organism> organismList = new ArrayList<>();

    public void run (Map<String, Integer> inputModel) {
      for (var organism: organismList) {
          organism.perform(inputModel);
      }
    }

    public void addOrganism(Organism organism) {
        organismList.add(organism);
    }

    public List<Organism> getOrganismList() {
        return organismList;
    }

}
