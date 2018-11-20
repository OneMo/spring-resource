package com.wdfu.config;

import com.wdfu.aop.LogAspects;
import com.wdfu.aop.MathCalculator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * AOP:[动态代理]
 *      值在程序运行期间动态的将某段代码切入到指定方法指定位置进行运行的编程方式
 *
 * 1、导入aop模块：spring aop：（spring-aspects）
 * 2、定义一个业务逻辑类MathCalculator：在业务逻辑运行的时候将日志进行打印（方法之前、方法运行结束，方法出现异常，XXX）
 * 3、定义一个日志切面类LogAspects：切面类里面的方法需要动态感知div运行到哪里 然后执行
 *          通知方法：
 *              前置通知(@Before)：logStart，在目标方法运行之前执行
 *              后置通知(@After)：logEnd，在目标方法运行结束之后执行
 *              返回通知(@AfterRetuning)：logReturn，在目标方法正常返回之后执行
 *              异常通知(@AfterThrowing)：logException，在目标方法出现异常之后执行
 *              环绕通知(@Around)：动态代理，手动推进目标方法执行（joinPoint.proced()）
 * 4、给切面类的目标方法标注何时何地运行（通知注解）
 * 5、将切面类和业务罗积类（目标方法所在的类）都加入到容器中；
 * 6、必须告诉spring 哪个类是切面类（@Aspect）
 * 【7】、给配置类中加@EnableAspectJAutoProxy 【开启基于注解的aop模式】
 *          在spring中很多的@EnableXXXX(都是开启某一项功能);
 *
 *
 * 三步：
 * 1)、将业务逻辑组件和切面类都加入到容器找那个，告诉spring那个是切面类（@Aspect）
 * 2)、在切面类上的每一个通知方法上标注通知注解，告诉spring何时何地运行（切入点表达式）
 * 3)、开启给予注释的aop模式：@EnableAspectJAutoProxy
 *
 *
 * AOP原理：看给容器中注册了什么组件  这个组件什么时候工作 【这个组件工作的时候功能是什么】
 *      @EnableAspectJAutoProxy
 * 1、@EnableAspectJAutoProxy是什么？
 *      @Import(AspectJAutoProxyRegistrar.class)： 给容器中导入AspectJAutoProxyRegistrar
 *          利用AspectJAutoProxyRegistrar自定义给容器中注册bean：internalAutoProxyCreator(name) = AnnotationAwareAspectJAutoProxyCreator(bean)
 *          给容器中注册一个AnnotationAwareAspectJAutoProxyCreator(注解自动代理对象器)
 * 2、AnnotationAwareAspectJAutoProxyCreator 结构关系
 *          AnnotationAwareAspectJAutoProxyCreator
 *              -> AspectJAwareAdvisorAutoProxyCreator
 *                  -> AbstractAdvisorAutoProxyCreator
 *                      -> AbstractAutoProxyCreator
 *                          -> implements SmartInstantiationAwareBeanPostProcessor, BeanFactoryAware
 *                          关注后置处理器BeanPostProcessor(在bean初始化完成前后做的事情)，自动装配BeanFactoryAware
 *  AbstractAutoProxyCreator类中相关的方法 ：
 *      AbstractAutoProxyCreator.setBeanFactory(BeanFactory beanFactory)
 *      AbstractAutoProxyCreator.postProcessBeforeInstantiation(Class<?> beanClass, String beanName)
 *      AbstractAutoProxyCreator.postProcessAfterInitialization(@Nullable Object bean, String beanName)
 *  AbstractAdvisorAutoProxyCreator 类中相关的方法：
 *      AbstractAdvisorAutoProxyCreator.setBeanFactory(BeanFactory beanFactory) ->initBeanFactory()
 *  AnnotationAwareAspectJAutoProxyCreator  类中相关的方法：
 *      AnnotationAwareAspectJAutoProxyCreator.initBeanFactory()
 *
 *
 *
 *      流程：
 *
 *      1、传入配置类，创建IOC容器
 *      2、注册配置类，调用refresh()刷新容器
 *      3、registerBeanPostProcessors(ConfigurableListableBeanFactory beanFactory) 注册bean的后置处理器来方便拦截bean的创建
 *          1）、先获取IOC容器已经定义了的需要创建对象的所有BeanPostProcessor
 *          2）、给容器中加入别的BeanPostProcessor
 *          3）、优先注册实现了PriorityOrdered接口的BeanPostProcessor
 *          4）、在给容器中注册实现了Ordered接口的BeanPostProcessor
 *          5）、注册没有实现优先级接口的BeanPostProcessor
 *          6）、注册BeanPostProcessor，实际上就是创建BeanPostProcessor对象，保存在容器中
 *                 创建org.springframework.aop.config.internalAutoProxyCreator的BeanPostProcessor实际上就是创建AnnotationAwareAspectJAutoProxyCreator对象
 *                 1）、createBeanInstance(beanName, mbd, args)：创建Bean的实例
 *                 2）、populateBean(beanName, mbd, instanceWrapper)：给bean的各种属性赋值
 *                 3）、initializeBean(beanName, exposedObject, mbd)：初始化bean
 *                      1）、invokeAwareMethods(beanName, bean)：处理Ware接口的回调
 *                      2）、applyBeanPostProcessorsBeforeInitialization(wrappedBean, beanName)：应用后置处理器的beanProcessor.postProcessBeforeInitialization(result, beanName);
 *                      3）、invokeInitMethods(beanName, wrappedBean, mbd);执行初始化方法
 *                      4）、applyBeanPostProcessorsAfterInitialization(wrappedBean, beanName);执行后置处理器的beanProcessor.postProcessAfterInitialization(result, beanName);
 *                 4)、BeanPostProcessor（AnnotationAwareAspectJAutoProxyCreator）创建成功
 *          7）、吧BeanPostProcessor注册到BeanFactory中： beanFactory.addBeanPostProcessor(postProcessor);
 *
 *
 *
 *
 *
 */
@EnableAspectJAutoProxy
@Configuration
public class MainConfigAop {

    @Bean
    public MathCalculator calculator(){
        return new MathCalculator();
    }

    @Bean
    public LogAspects logAspects(){
        return new LogAspects();
    }
}
