package com.wdfu.condition;

import com.wdfu.bean.RainBow;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

    /**
     * 把所有需要添加到容器中的bean  调用registerBeanDefinitions()手工注册到容器中
     * @param importingClassMetadata 当前类注解信息
     * @param registry beanDefinition注册类
     */
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        boolean color = registry.containsBeanDefinition("com.wdfu.bean.Color");
        boolean red = registry.containsBeanDefinition("com.wdfu.bean.Red");
        if(color && red){
            RootBeanDefinition beanDefinition = new RootBeanDefinition(RainBow.class);
            registry.registerBeanDefinition("rainBow",beanDefinition);
        }
    }
}
