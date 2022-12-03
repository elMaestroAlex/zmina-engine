package com.asterai.zmina.engine;

import com.asterai.zmina.logic.MindModel;
import com.asterai.zmina.logic.MindsetNode;
import com.asterai.zmina.organism.Organism;
import com.asterai.zmina.parser.Parser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ZminaEngine {

    Map<String, MindsetNode> mindset;

    private Parser parser = new Parser();
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

    public void loadMindset(String fileName) {
        mindset = parser.parseFile(fileName);
    }
}
