package com.wdfu;

import com.wdfu.bean.Person;
import com.wdfu.config.MainConfig2;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Map;

public class BeanTest {
    AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(MainConfig2.class);

    public void printBean(){
        String[] beanDefinitionNames = annotationConfigApplicationContext.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }
    }

    @Test
    public void test1(){
        printBean();
        Person bean = annotationConfigApplicationContext.getBean(Person.class);
        Person bean2 = annotationConfigApplicationContext.getBean(Person.class);
        System.out.println(bean);
        System.out.println(bean == bean2);
    }


    @Test
    public void test2(){
        printBean();
        Map<String, Person> beansOfType = annotationConfigApplicationContext.getBeansOfType(Person.class);
        System.out.println(beansOfType);
    }
}
