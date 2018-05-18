package cn.oursmedia.springioc.sample1;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

@Slf4j
public class CustomerBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        log.info("9, BeanPostProcessor.postProcessBeforeInitialization方法,beanName=" + beanName);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        log.info("13, BeanPostProcessor.postProcessAfterInitialization方法,beanName=" + beanName);
        return bean;
    }


}
