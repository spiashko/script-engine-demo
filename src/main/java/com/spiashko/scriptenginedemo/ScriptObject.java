package com.spiashko.scriptenginedemo;

import lombok.SneakyThrows;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@ToString
@Slf4j
public class ScriptObject {

    private boolean isDone = false;

    @SneakyThrows
    public void doSomething(String arg){
        log.info("script object started to do something");
        log.info("processing arg: " + arg);
        isDone = true;
        log.info("script object finished to do something");
    }

}
