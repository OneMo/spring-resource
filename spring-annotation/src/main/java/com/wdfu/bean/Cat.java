package com.wdfu.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Cat implements InitializingBean,DisposableBean {

    public Cat() {
        System.out.println("cat....constructor...");
    }


    public void afterPropertiesSet() throws Exception {
        System.out.println("cat....afterPropertiesSet...");

    }


    public void destroy() throws Exception {
        System.out.println("cat....destroy...");
    }


}
