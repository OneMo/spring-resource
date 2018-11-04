package com.wdfu.bean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Dog {

    public Dog() {
        System.out.println("dog...constructor....");
    }

    @PostConstruct
    public void init(){
        System.out.println("dog...init");
    }

    @PreDestroy
    public void destory(){
        System.out.println("dog...destory");
    }
}
