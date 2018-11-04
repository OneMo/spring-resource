package com.wdfu.bean;

import org.springframework.beans.factory.FactoryBean;

public class ColorFactory implements FactoryBean<Color> {
    /**
     * 返回一个创建对象 这个对象将会被添加到容器中
     * @return
     * @throws Exception
     */
    public Color getObject() throws Exception {
        return new Color();
    }

    public Class<?> getObjectType() {
        return Color.class;
    }

    /**
     * 是否为单实例
     * true:单实例
     * false:多实例
     * @return
     */
    public boolean isSingleton() {
        return true;
    }
}
