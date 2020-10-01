package com.spiashko.scriptenginedemo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;

import javax.script.Bindings;
import javax.script.ScriptEngine;
import javax.script.ScriptException;

@Slf4j
@RequiredArgsConstructor
public class ScriptEngineService {

    private static final Logger scriptLog = org.slf4j.LoggerFactory.getLogger("ScriptLogger");

    private final ScriptEngine engine;

    public void eval(String script, ScriptObject object) throws ScriptException {

        Bindings bindings = engine.createBindings();
        bindings.put("log", scriptLog);
        bindings.put("scriptObject", object);

        ScriptResult result = (ScriptResult) engine.eval(script, bindings);
        log.info("script eval result: " + result);
    }

}
