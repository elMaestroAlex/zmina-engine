package com.asterai.zmina.processor;

import com.asterai.zmina.logic.LogicNode;

import java.util.Map;

public interface LogicProcessor {
    void run(LogicNode logic, Map<String, Integer> inputModel);
}
