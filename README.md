# spring-resource
spring源码学习

## 第一部分、spring-annotation   -------注解介绍及使用
##### 1) @Bean 像spring注册一个bean
	返回类型为bean的类型  如果@Bean("id")的value有值 那么bean的id为value 否则方法名作为bean的id
##### 2）@Configuration 表示这个类为配置类
##### 3) @ComponentScan  扫描注解 ****
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
    
##### 4) @Scope bean的作用域  <br>
	详情见spring-resource\spring-annotation\src\main\java\com\wdfu\config\MainConfig2.java  ---person
##### 5) @Lazy  bean的加载时机  <br>
 	详情见spring-resource\spring-annotation\src\main\java\com\wdfu\config\MainConfig2.java ---person1
##### 6) @Conditional  满足条件加载bean 可作用于方法上和类上 <br>
 	需要实现Condition接口  实现match方法  进行条件判断  例如spring-resource\spring-annotation\src\main\java\com\wdfu\condition包下的
##### 6) @Import()  导入第三方组件 作用于类上 <br>
	1、直接导入 例如：@Import({Color.class,Red.class}) 组件的id为全类名
	2、使用ImportSelector导入 例如：@Import({MyImportSelector.class}) 组件的id为全类名
	3、使用ImportBeanDefinitionRegistrar手工注册 例如：\spring-resource\spring-annotation\src\main\java\com\wdfu\condition\MyImportBeanDefinitionRegistrar.java
	4、使用spring提供的FactoryBean 例如：\spring-resource\spring-annotation\src\main\java\com\wdfu\bean\ColorFactory.java
                        
#### 7) bean的生命周期  初始化方法和销毁方法
	1、通过@Bean指定init-method和destory-method  例如：\spring-resource\spring-annotation\src\main\java\com\wdfu\config\MainCOnfigOfLifeCycle.java  ---test1()
	2、让bean实现InitializingBean和DisposableBean 例如 \spring-resource\spring-annotation\src\main\java\com\wdfu\bean\Cat.java
	3、使用JSR250规范 使用@PostConstruct和@PreDestroy注解  例如：\spring-resource\spring-annotation\src\main\java\com\wdfu\bean\Dog.java
                        
#### 8) BeanPostProcessor 初始化之前调用和初始化之后调用  
                        遍历得到容器中所有的BeanPostProcessor，挨个执行postProcessBeforeInitialization
                        一旦返回null 则跳出for循环  源代码见AbstractAutowireCapableBeanFactory.applyBeanPostProcessorsAfterInitialization()
                        调用的生命周期：
                        ......对bean进行属性的赋值等操作
                        initializeBean：{
                                    //调用初始化之前的方法
                        			wrappedBean = applyBeanPostProcessorsBeforeInitialization(wrappedBean, beanName);
                        			//调用初始化方法
			                        invokeInitMethods(beanName, wrappedBean, mbd);
			                        //调用初始化之后的方法
			                        wrappedBean = applyBeanPostProcessorsAfterInitialization(wrappedBean, beanName);
                        }
                                
                        
## 第二部分、                     
