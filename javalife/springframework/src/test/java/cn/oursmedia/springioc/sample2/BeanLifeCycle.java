package cn.oursmedia.springioc.sample2;

/**
 * https://www.cnblogs.com/zrtqsk/p/3735273.html
 * 2, BeanFactoryPostProcessor constructor！！, BeanFactory构造结束之后执行
 * 3, BeanFactoryPostProcessor.postProcessBeanFactory方法
 * 4, BeanPostProcessor constructor！！
 * 5, InstantiationAwareBeanPostProcessorAdapter constructor！！
 * 6, InstantiationAwareBeanPostProcessorAdapter.postProcessBeforeInstantiation方法
 * 7 person constructor
 * 8 InstantiationAwareBeanPostProcessorAdapter.postProcessPropertyValues方法
 * 9 person.setAddress()
 * 10 person.setName()
 * 11 person.setPhone()
 * 12 person:BeanNameAware.setBeanName()
 * 13 person:BeanFactoryAware.setBeanFactory()
 * 14 BeanPostProcessor.postProcessBeforeInitialization对属性进行更改！
 * 15 person:InitializingBean.afterPropertiesSet()
 * 16 person:init-method属性指定的初始化方法
 * 17 BeanPostProcessor.postProcessAfterInitialization对属性进行更改！
 * 18 InstantiationAwareBeanPostProcessorAdapter.postProcessAfterInitialization方法
 * 容器初始化成功
 * Person [address=广州, name=张三, phone=110]
 * 现在开始关闭容器！
 * 22 person:DiposibleBean.destory()
 * 23 person:destroy-method属性指定的初始化方法
 */

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLifeCycle {
    @Test
    public void testBeanLifeCycle() {

        System.out.println("1 现在开始初始化容器, 步骤2-19");

        ApplicationContext factory = new ClassPathXmlApplicationContext("sample2.xml");
        System.out.println("容器初始化成功");
        //得到Preson，并使用
        Person person = factory.getBean("person",Person.class);
        System.out.println(person);

        System.out.println("现在开始关闭容器！ 步骤21-23");
        ((ClassPathXmlApplicationContext)factory).registerShutdownHook();
    }
}