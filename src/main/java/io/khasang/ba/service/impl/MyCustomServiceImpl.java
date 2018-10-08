package io.khasang.ba.service.impl;

import io.khasang.ba.service.MyService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
@Qualifier("second")
//@Scope("application")
public class MyCustomServiceImpl implements MyService {
    @Override
    public String getName() {
        return "Been from interface qualifier second";
    }

    @PostConstruct
    public void init() {
        System.err.println("BEFORE INIT");
    }

    @PreDestroy
    public void cleanUp() {
        System.err.println("Does class destroy");
    }
}
