package project.java.config;

import org.springframework.beans.factory.config.CustomScopeConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.SimpleThreadScope;
import org.springframework.stereotype.Component;
import project.java.repository.CrudRepository;
import project.java.utils.ConnectionPool;
import web.WebConfig;

import java.util.HashMap;
import java.util.Map;

@Import(WebConfig.class)
@ImportResource("classpath:application.xml")
@Configuration(proxyBeanMethods = true)
@ComponentScan(basePackages = "project.java",
        useDefaultFilters = false,
        includeFilters = {
                @ComponentScan.Filter(type = FilterType.ANNOTATION, value = Component.class),
                @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, value = CrudRepository.class),
                @ComponentScan.Filter(type = FilterType.REGEX, pattern = "com\\..+Repository")
        })
@PropertySource("classpath:application.properties")
@EnableAspectJAutoProxy
public class JavaConfig {

    @Bean
    public SimpleThreadScope simpleThreadScope() {
        //System.out.println("HTTP :: " + httpVersion);
        return new SimpleThreadScope();
    }

    @Bean
    public CustomScopeConfigurer customScopeConfigurer(SimpleThreadScope simpleThreadScope) {
        CustomScopeConfigurer customScopeConfigurer = new CustomScopeConfigurer();
        Map<String, Object> scopes = new HashMap<>();
        scopes.put("thread", simpleThreadScope);
        customScopeConfigurer.setScopes(scopes);
        return customScopeConfigurer;
    }

    @Bean
    public ConnectionPool pool2() {
        return new ConnectionPool("asd", 2);
    }

    @Bean
    public ConnectionPool pool5() {
        System.out.println("pool2=" + pool2());
        System.out.println("pool2=" + pool2());
        return new ConnectionPool("test", 5);
    }
//    @Bean
//    public LoggingAspect loggingAspect() {
//        return new LoggingAspect();
//    }

}
