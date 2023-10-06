package project.java;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class CustomBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("STEP 5. BeanPostProcessor [" + beanName + "] (CustomBeanPostProcessor/postProcessBeforeInitialization)");
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("STEP 9. BeanPostProcessor [" + beanName + "] (CustomBeanPostProcessor/postProcessAfterInitialization)");
        return bean;
    }
}
