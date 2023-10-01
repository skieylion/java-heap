package project.java;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.CommonAnnotationBeanPostProcessor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@ComponentScan(basePackages = "project.java")
@Configuration
@ImportResource("classpath:beans.xml")
public class Config {
    @Bean(value = "version")
    public String version() {
        return "1.2.3";
    }

    @Bean
    public CustomBeanPostProcessor customBeanPostProcessor() {
        return new CustomBeanPostProcessor();
    }

    @Bean
    public CommonAnnotationBeanPostProcessor commonAnnotationBeanPostProcessor() {
        return new CommonAnnotationBeanPostProcessor();
    }

    @Bean(value = "testService", initMethod = "customInitMethod", destroyMethod = "customDestroyMethod")
    public TestService testService() {
        return new TestService();
    }
}
