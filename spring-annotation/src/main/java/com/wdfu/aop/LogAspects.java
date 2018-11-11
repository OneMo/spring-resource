package com.wdfu.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.Arrays;

/**
 * 切面类
 * @Aspect 告诉spring 当前类是一个切面类
 * JoinPoint joinPoint这个参数一定要放在参数表的第一位
 */
@Aspect
public class LogAspects {

    /**
     * 1、本类引用
     * 2、其他切面引用
     */
    @Pointcut("execution(public int com.wdfu.aop.MathCalculator.*(..))")
    public void pointCut(){}

    /**
     * @Before 在目标方法之前切入，切入点表达式（指定在哪个方法切入）
     */
    @Before("pointCut()")
    public void logStart(JoinPoint joinPoint){
        Object[] args = joinPoint.getArgs();
        System.out.println(""+joinPoint.getSignature().getName()+"除法运行......参数列表是：{}:"+ Arrays.asList(args));
    }

    @After("pointCut()")
    public void logEnd(JoinPoint joinPoint){
        System.out.println(joinPoint.getSignature().getDeclaringTypeName()+"除法结束");
    }

    @AfterReturning(value = "pointCut()",returning = "result")
    public void logReturn(Object result){
        System.out.println("除法正常返回......运行结果是：{}:"+result.toString());
    }

    @AfterThrowing(value = "pointCut()",throwing = "exception")
    public void logException(Exception exception){
        System.out.println("除法异常......异常信息：{}:"+exception);
    }


}
