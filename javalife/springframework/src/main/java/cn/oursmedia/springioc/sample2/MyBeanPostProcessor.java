package cn.oursmedia.springioc.sample2;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

@Slf4j
public class MyBeanPostProcessor implements BeanPostProcessor {

    public MyBeanPostProcessor() {
        super();
        log.info("4, BeanPostProcessor constructor！！");
    }
    @Override
    public Object postProcessAfterInitialization(Object arg0, String arg1)
            throws BeansException {
        log.info("18 BeanPostProcessor.postProcessAfterInitialization对属性进行更改！");
        return arg0;
    }
    @Override
    public Object postProcessBeforeInitialization(Object arg0, String arg1)
            throws BeansException {
        log.info("14 BeanPostProcessor.postProcessBeforeInitialization对属性进行更改！");
        return arg0;
    }
}