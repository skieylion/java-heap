package project.java.config;

import feign.Client;
import feign.Logger;
import feign.Request;
import feign.RequestInterceptor;
import feign.RetryableException;
import feign.Retryer;
import feign.codec.Decoder;
import feign.codec.ErrorDecoder;
import feign.httpclient.ApacheHttpClient;
import feign.okhttp.OkHttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.openfeign.support.FeignHttpClientProperties;
import org.springframework.cloud.openfeign.support.ResponseEntityDecoder;
import org.springframework.cloud.openfeign.support.SpringDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import project.java.feigns.CustomRetryer;

import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;

public class FeignClientConfig {

    int connectTimeoutMillis = 1000;
    int readTimeoutMillis = 5000;

    @Bean
    public Retryer retryer() {
        return new CustomRetryer();
    }

    @Bean
    public Request.Options options() {
        return new Request.Options(connectTimeoutMillis, readTimeoutMillis, true);
    }


    @Bean
    public Logger.Level feignLoggerLevel() {
        System.out.println("Загружен ....");
        return Logger.Level.FULL;
    }
//
//    @Bean
//    public RequestInterceptor requestInterceptor() {
//        return new FeignInterceptor();
//    }

    @Bean
    public ErrorDecoder errorDecoder() {
        return new CustomErrorDecoder();
    }
//
//    @Bean
//    public OkHttpClient client() {
//        return new OkHttpClient();
//    }

    @Bean
    public Client httpClient(FeignHttpClientProperties httpClientProperties)
            throws NoSuchAlgorithmException, KeyStoreException, KeyManagementException {
        RequestConfig defaultRequestConfig = RequestConfig
                .custom()
                .setConnectTimeout(1000)
                .setRedirectsEnabled(httpClientProperties.isFollowRedirects())
                .build();

        CloseableHttpClient httpClient = HttpClients.custom()
                .setDefaultRequestConfig(defaultRequestConfig)
                .setMaxConnTotal(1)
                .setMaxConnPerRoute(1)
                .build();
        return new ApacheHttpClient(httpClient);
    }


}
