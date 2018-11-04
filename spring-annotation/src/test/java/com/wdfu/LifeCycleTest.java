package com.wdfu;

import com.wdfu.bean.Car;
import com.wdfu.config.MainConfigOfLifeCycle;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class LifeCycleTest {
    AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(MainConfigOfLifeCycle.class);

    @Test
    public void test1(){
        Car bean = annotationConfigApplicationContext.getBean(Car.class);
        System.out.println(bean);
        annotationConfigApplicationContext.close();
    }


}
