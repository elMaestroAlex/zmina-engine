package com.asterai.zmina.parser;

import com.asterai.zmina.logic.MindsetNode;

import java.util.List;
import java.util.Map;

interface MindsetElementBuilder {

     /**
      * Builds element of mindset (eg. MindModel, Interface e.t.c)
      *
      * @return new pos of cursor
      */
    int build(List<Token> tokens, Map<String, MindsetNode> mindSet, int cursorPos);
}
