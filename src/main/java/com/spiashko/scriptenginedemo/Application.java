package com.spiashko.scriptenginedemo;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

@Slf4j
public class Application {


    public static void main(String[] args) {
        new Application().run();
    }

    @SneakyThrows
    public void run() {
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("JavaScript");
        InputStream scriptAsStream = Application.class.getClassLoader().getResourceAsStream("script.js");
        String script = IOUtils.toString(Objects.requireNonNull(scriptAsStream), StandardCharsets.UTF_8.name());
        ScriptEngineService service = new ScriptEngineService(engine);

        ScriptObject scriptObject = new ScriptObject();
        log.info("script object before: " + scriptObject);
        service.eval(script, scriptObject);
        log.info("script object after: " + scriptObject);
    }

}
