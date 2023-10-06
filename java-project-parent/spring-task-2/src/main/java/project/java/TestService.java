package project.java;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class TestService implements BeanNameAware, BeanFactoryAware, ApplicationContextAware, InitializingBean, DisposableBean {

    @Lookup
    public TestService self() {
        return null;
    }

    public void test() {
        System.out.println("TestService lookup");
        System.out.println(self());
        System.out.println(self());
        //self().todo();
        System.out.println("TestService");
    }

    public void todo() {
        System.out.println("TestService todo");
    }

    @Override
    public void setBeanName(String s) {
        System.out.println("STEP 2. BeanNameAware (" + s + ")");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        //var bean = beanFactory.getBean("version", String.class);
        System.out.println("STEP 3. BeanFactoryAware (" + beanFactory + ")");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("STEP 4: ApplicationContextAware (TestService)");
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("STEP 6. PostConstruct (TestService)");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("STEP 10. PreDestroy (TestService)");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("STEP 11. Destroy (TestService)");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("STEP 7. afterPropertiesSet (TestService)");
    }

    private void customInitMethod() {
        System.out.println("STEP 8. TestService. customInitMethod");
    }

    private void customDestroyMethod() {
        System.out.println("STEP 12. TestService. customDestroyMethod");
    }
}
