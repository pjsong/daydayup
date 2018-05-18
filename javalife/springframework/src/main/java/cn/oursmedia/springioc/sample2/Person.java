package cn.oursmedia.springioc.sample2;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Slf4j
public class Person implements BeanFactoryAware, BeanNameAware,
        InitializingBean, DisposableBean {

    private String name;
    private String address;
    private String phone;

    private BeanFactory beanFactory;
    private String beanName;

    public Person() {
        log.info("7 person constructor");
    }
    public void setName(String name) {
        log.info("10 person.setName()");
        this.name = name;
    }
    public void setAddress(String address) {
        log.info("9 person.setAddress()");
        this.address = address;
    }
    public void setPhone(String phone) {
        log.info("11 person.setPhone()");
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }


    public String getPhone() {
        return phone;
    }
    public String getName() {
        return name;
    }
    @Override
    public String toString() {
        return "Person [address=" + address + ", name=" + name + ", phone="
                + phone + "]";
    }

    // 这是BeanFactoryAware接口方法
    // BeanFactoryAware接口方法
    @Override
    public void setBeanFactory(BeanFactory arg0) throws BeansException {
        log.info("13 person:BeanFactoryAware.setBeanFactory()");
        this.beanFactory = arg0;
    }

    // BeanNameAware接口方法
    @Override
    public void setBeanName(String arg0) {
        log.info("12 person:BeanNameAware.setBeanName()");
        this.beanName = arg0;
    }
    // InitializingBean接口方法
    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("15 person:InitializingBean.afterPropertiesSet()");
    }
    // DiposibleBean接口方法
    @Override
    public void destroy() throws Exception {
        log.info("22 person:DiposibleBean.destory()");
    }
    // 通过<bean>的init-method属性指定的初始化方法
    public void myInit() {
        log.info("17 person:init-method属性指定的初始化方法");
    }
    // 通过<bean>的destroy-method属性指定的初始化方法
    public void myDestory() {
        log.info("23 person:destroy-method属性指定的初始化方法");
    }

    //要注入CommonAnnotationBeanPostProcessor
    @PostConstruct
    public void initPostConstruct(){
        log.info("16 @PostConstruct注解的方法, 要注入CommonAnnotationBeanPostProcessor");
    }
    @PreDestroy
    public void preDestroy(){
        log.info("21 @preDestroy注解的方法,要注入CommonAnnotationBeanPostProcessor");
    }
}