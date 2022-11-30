package com.asterai.zmina.organism;

import java.util.Map;

public interface Organism {
    String getName();
    int getState();
    void perform(Map<String, Integer> inputModel);
}
