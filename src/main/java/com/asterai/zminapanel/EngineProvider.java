package com.asterai.zminapanel;

import com.asterai.zmina.engine.ZminaEngine;

public class EngineProvider {

    private static final EngineProvider INSTANCE = new EngineProvider();

    private ZminaEngine engine = new ZminaEngine();

    public static EngineProvider getInstance() {
        return INSTANCE;
    }

    ZminaEngine getEngine() {
        return engine;
    }
}
