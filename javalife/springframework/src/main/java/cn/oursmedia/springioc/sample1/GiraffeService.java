package cn.oursmedia.springioc.sample1;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.*;
import org.springframework.context.annotation.ImportAware;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.type.AnnotationMetadata;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.Arrays;

@Slf4j
public class GiraffeService implements InitializingBean,DisposableBean,ApplicationContextAware,
        ApplicationEventPublisherAware, BeanClassLoaderAware, BeanFactoryAware,
        BeanNameAware, EnvironmentAware, ImportAware, ResourceLoaderAware{

    private String name;

    public String getName() {
        return name;
    }

    public GiraffeService setName(String name) {
        log.info("2, GiraffeService中利用set方法设置属性值");
        this.name = name;
        return this;
    }

    public GiraffeService(){
        log.info("1, GiraffeService(): empty constructor");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("11 InitializingBean.afterPropertiesSet方法");

    }

    @Override
    public void destroy() throws Exception {
        log.info("22 DisposableBean.destroy方法");
    }


    //通过<bean>的destroy-method属性指定的销毁方法
    public void destroyMethod()  {
        log.info("23 配置的destroy-method");
    }

    //通过<bean>的init-method属性指定的初始化方法
    public void initMethod()  {
        log.info("12 配置的init-method");
    }

    @PostConstruct
    public void initPostConstruct(){
        log.info("10 @PostConstruct注解的方法");
    }

    @PreDestroy
    public void preDestroy(){
        log.info("21 @preDestroy注解的方法");
    }


    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        log.info("4, BeanClassLoaderAware.setBeanClassLoader,ClassLoader Name = " + classLoader.getClass().getName());
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        log.info("5, BeanFactoryAware.setBeanFactory:: giraffe bean singleton=" +  beanFactory.isSingleton("giraffeService"));
    }

    @Override
    public void setBeanName(String s) {
        log.info("3, BeanNameAware.setBeanName, Bean Name defined in context="
                + s);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        log.info("8 ApplicationContextAware.setApplicationContext:: Bean Definition Names="
                + Arrays.toString(applicationContext.getBeanDefinitionNames()));

    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        log.info("7 ApplicationEventPublisherAware.setApplicationEventPublisher");
    }

    @Override
    public void setEnvironment(Environment environment) {
        log.info("6. EnvironmentAware.setEnvironment");
    }

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        Resource resource = resourceLoader.getResource("classpath:sample1.xml");
        log.info("6, ResourceLoaderAware.setResourceLoader:: Resource File Name="
                + resource.getFilename());

    }

    @Override
    public void setImportMetadata(AnnotationMetadata annotationMetadata) {
        log.info("执行setImportMetadata");
    }
}
