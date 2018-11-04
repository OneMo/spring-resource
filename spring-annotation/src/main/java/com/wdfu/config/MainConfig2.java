package com.wdfu.config;

import com.wdfu.bean.Color;
import com.wdfu.bean.Person;
import com.wdfu.bean.Red;
import com.wdfu.condition.LinuxCondition;
import com.wdfu.condition.MyImportBeanDefinitionRegistrar;
import com.wdfu.condition.MyImportSelector;
import com.wdfu.condition.WindowsCondition;
import org.springframework.context.annotation.*;

import static org.springframework.beans.factory.config.ConfigurableBeanFactory.SCOPE_SINGLETON;

@Configuration
@Import({Color.class,Red.class,MyImportSelector.class,MyImportBeanDefinitionRegistrar.class})
public class MainConfig2 {
    /**
     *  ConfigurableBeanFactory
     *
     *  SCOPE_SINGLETON：单实例 在ioc容器启动时会调用方法创建对象放到ioc容器中，以后每次获取直接从容器中拿
     *  SCOPE_PROTOTYPE: 多实例 在ioc容器启动时不会调用方法创建对象放到ioc容器中，每次获取bean时才会调用方法创建对象放到ioc容器中
     *
     * @return
     */
    @Scope(SCOPE_SINGLETON)
    @Bean
    public Person person(){
        return new Person("wdfu",24);
    }



    /**
     *
     * 懒加载：针对的是单实例bean,在容器启动后不创建对象，在第一次获取bean时创建对象放入ioc容器中并初始化
     *
     * @return
     */
    @Lazy
    @Bean
    public Person person1(){
        return new Person("onemo",22);
    }

    @Conditional(WindowsCondition.class)
    @Bean
    public Person person2(){
        return new Person("bill ",64);
    }

    @Conditional(LinuxCondition.class)
    @Bean
    public Person person3(){
        return new Person("linux",48);
    }





}
