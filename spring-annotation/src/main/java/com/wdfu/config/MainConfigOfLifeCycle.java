package com.wdfu.config;

import com.wdfu.bean.Car;
import com.wdfu.bean.Cat;
import com.wdfu.bean.Dog;
import com.wdfu.bean.MyBeanProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * bean的生命周期
 *      bean的创建-------初始化-------销毁的过程
 * 容器管理bean的生命周期：
 * 我们可以自定义初始化和销毁方法，容器在bean进行到当前生命周期的时候来调用我们自定义的初始化和销毁方法
 *
 * 初始化：
 *          对象在创建完成，并赋值好后，调用初始化方法....
 * 销毁：
 *          单实例:容器关闭的时候
 *          多实例：容器不会管理这个bean,容器不会调用销毁方法
 *
 * 1）、指定初始化和销毁方法：
 *          通过@Bean指定init-method和destory-method；
 *
 */
@Configuration
public class MainConfigOfLifeCycle {

    @Bean(initMethod = "init",destroyMethod = "destory")
    public Car car(){
        return new Car();
    }


    @Bean()
    public Cat cat(){
        return new Cat();
    }

    @Bean()
    public Dog dog(){
        return new Dog();
    }

    @Bean()
    public MyBeanProcessor myBeanProcessor(){
        return new MyBeanProcessor();
    }
}
