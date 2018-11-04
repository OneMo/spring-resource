# spring-resource
spring源码学习

**第一部分、spring-annotation**
1）@Bean 像spring注册一个bean
      返回类型为bean的类型  如果@Bean("id")的value有值 那么bean的id为value 否则方法名作为bean的id
2）@Configuration 表示这个类为配置类
3) @ComponentScan  扫描注解 ****
    1、指定value 则扫描这个包下的类  例如@ComponentScan(value = "com.wdfu")  则表示扫描"com.wdfu"这个包下的所有类
    2、指定排除那些类 例如 @ComponentScan(value = "com.wdfu",excludeFilters = {
                         @ComponentScan.Filter(type = FilterType.ANNOTATION,classes = {Controller.class})
                 })
                 表示排除Controller.class这个注解  排除类型详见 FilterType类
                 
    3、指定包含那些列类  例如@ComponentScan(value = "com.wdfu",includeFilters = {
                          @ComponentScan.Filter(type = FilterType.ANNOTATION,classes = {Controller.class})
                  },useDefaultFilters = false)
                  表示指定扫描Controller注解的类
    
    4、自定义规则类型  例如spring-resource\spring-annotation\src\main\java\com\wdfu\config\MyTypeFilter.java 中实现了TypeFilter接口 自定义过滤规则
    
    
