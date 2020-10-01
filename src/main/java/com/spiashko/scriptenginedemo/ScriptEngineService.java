package com.spiashko.scriptenginedemo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.script.Bindings;
import javax.script.ScriptEngine;
import javax.script.ScriptException;

@Slf4j
@RequiredArgsConstructor
public class ScriptEngineService {

    private final ScriptEngine engine;

    public void eval(String script, ScriptObject object) throws ScriptException {

        Bindings bindings = engine.createBindings();
        bindings.put("log", log);
        bindings.put("scriptObject", object);

        engine.eval(script, bindings);
    }

}
