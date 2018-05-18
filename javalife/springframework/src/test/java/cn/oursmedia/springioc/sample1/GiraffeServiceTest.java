package cn.oursmedia.springioc.sample1;

/**
 * https://yemengying.com/2016/07/14/spring-bean-life-cycle/
 * 1, GiraffeService(): empty constructor
 * 2, GiraffeService中利用set方法设置属性值
 * 3, BeanNameAware.setBeanName, Bean Name defined in context=giraffeService
 * 4, BeanClassLoaderAware.setBeanClassLoader,ClassLoader Name = sun.misc.Launcher$AppClassLoader
 * 5, BeanFactoryAware.setBeanFactory:: giraffe bean singleton=true
 * 6. EnvironmentAware.setEnvironment
 * 6, ResourceLoaderAware.setResourceLoader:: Resource File Name=sample1.xml
 * 7 ApplicationEventPublisherAware.setApplicationEventPublisher
 * 8 ApplicationContextAware.setApplicationContext:: Bean Definition Names=[giraffeService, org.springframework.context.annotation.CommonAnnotationBeanPostProcessor#0, cn.oursmedia.springioc.sample1.CustomerBeanPostProcessor#0]
 * 9, BeanPostProcessor.postProcessBeforeInitialization方法,beanName=giraffeService
 * 10 @PostConstruct注解的方法
 * 11 InitializingBean.afterPropertiesSet方法
 * 12 配置的init-method
 * 13, BeanPostProcessor.postProcessAfterInitialization方法,beanName=giraffeService
 * Spring容器初始化完毕
 * =====================================
 * 从容器中获取Bean
 * giraffe Name=Bill Gates
 * =====================================
 * May 17, 2018 12:51:03 PM org.springframework.context.support.ClassPathXmlApplicationContext doClose
 * INFO: Closing org.springframework.context.support.ClassPathXmlApplicationContext@64b8f8f4: startup date [Thu May 17 12:51:03 CST 2018]; root of context hierarchy
 * 21 @preDestroy注解的方法
 * 22 DisposableBean.destroy方法
 * 23 配置的destroy-method
 * Spring容器关闭
 */



import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class GiraffeServiceTest {

    @Test
    public void testBeanLifeCycle(){

        System.out.println("Spring容器初始化");
        System.out.println("=====================================");

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("sample1.xml");

        System.out.println("Spring容器初始化完毕");
        System.out.println("=====================================");

        System.out.println("从容器中获取Bean");

        GiraffeService service = context.getBean("giraffeService", GiraffeService.class);

        System.out.println("giraffe Name="+service.getName());
        System.out.println("=====================================");

        context.close();

        System.out.println("Spring容器关闭");

    }

}
