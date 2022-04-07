package project.java.config;

import feign.RequestInterceptor;
import feign.RequestTemplate;

public class FeignInterceptor implements RequestInterceptor {
    @Override
    public void apply(RequestTemplate requestTemplate) {
        System.out.println("a user interceptor");
        requestTemplate.header("token","This is sdasd");
    }
}
