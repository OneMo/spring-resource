package com.wdfu.bean;

import lombok.Data;

@Data
public class Person {
    private String name;
    private Integer age;

    public Person() {

    }

    public Person(String name, Integer age) {
        System.out.println("person Constructor.....");
        this.name = name;
        this.age = age;
    }
}
