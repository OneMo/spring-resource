package com.wdfu;

import com.wdfu.aop.MathCalculator;
import com.wdfu.bean.Car;
import com.wdfu.config.MainConfigAop;
import com.wdfu.config.MainConfigOfLifeCycle;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class IOCTest_SOP {
    AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(MainConfigAop.class);

    @Test
    public void test1(){
        MathCalculator bean = annotationConfigApplicationContext.getBean(MathCalculator.class);
        bean.div(1,1);
        annotationConfigApplicationContext.close();
    }


}
