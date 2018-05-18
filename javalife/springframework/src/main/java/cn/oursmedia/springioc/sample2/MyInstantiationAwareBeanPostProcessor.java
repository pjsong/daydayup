package cn.oursmedia.springioc.sample2;

import java.beans.PropertyDescriptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessorAdapter;

@Slf4j
public class MyInstantiationAwareBeanPostProcessor extends
        InstantiationAwareBeanPostProcessorAdapter {

    public MyInstantiationAwareBeanPostProcessor() {
        super();
        log.info("5, InstantiationAwareBeanPostProcessorAdapter constructor！！");
    }
    @Override
    public Object postProcessBeforeInstantiation(Class beanClass,
                                                 String beanName) throws BeansException {
        log.info("6, InstantiationAwareBeanPostProcessorAdapter.postProcessBeforeInstantiation方法");
        return null;
    }

    // 接口方法、实例化Bean之后调用
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        log.info("19 InstantiationAwareBeanPostProcessorAdapter.postProcessAfterInitialization方法");
        return bean;
    }
    // 接口方法、设置某个属性时调用
    @Override
    public PropertyValues postProcessPropertyValues(PropertyValues pvs,
                                                    PropertyDescriptor[] pds, Object bean, String beanName) throws BeansException {
        log.info("8 InstantiationAwareBeanPostProcessorAdapter.postProcessPropertyValues方法");
        return pvs;
    }
}