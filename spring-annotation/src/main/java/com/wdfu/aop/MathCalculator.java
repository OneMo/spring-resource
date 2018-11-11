package com.wdfu.aop;

public class MathCalculator {

    public int div(int i,int j){
        System.out.println("MathCalculator.div方法被调用");
        return i/j;
    }
}
