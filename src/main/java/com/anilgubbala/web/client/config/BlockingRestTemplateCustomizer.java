//package com.anilgubbala.web.client.config;
//
//
//
//import org.apache.http.client.HttpClient;
//import org.apache.http.client.config.RequestConfig;
//import org.apache.http.impl.client.CloseableHttpClient;
//import org.apache.http.impl.client.DefaultConnectionKeepAliveStrategy;
//import org.apache.http.impl.client.HttpClients;
//import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
//import org.springframework.boot.web.client.RestTemplateCustomizer;
//import org.springframework.http.client.ClientHttpRequestFactory;
//import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
//import org.springframework.stereotype.Component;
//import org.springframework.web.client.RestTemplate;
//
//@Component
//public class BlockingRestTemplateCustomizer implements RestTemplateCustomizer {
//
//    private ClientHttpRequestFactory clientHttpRequestFactory() {
//        // Creating a connection manager with connection pooling settings
//        PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager();
//        connectionManager.setMaxTotal(100);
//        connectionManager.setDefaultMaxPerRoute(20);
//
//        // Configuring request timeouts
//        RequestConfig requestConfig = RequestConfig
//                .custom()
//                .setConnectionRequestTimeout(3000)
//                .setSocketTimeout(3000)
//                .build();
//
//        // Creating a custom HttpClient
//        CloseableHttpClient httpClient = HttpClients
//                .custom()
//                .setConnectionManager(connectionManager)
//                .setKeepAliveStrategy(new DefaultConnectionKeepAliveStrategy())
//                .setDefaultRequestConfig(requestConfig)
//                .build();
//
//        HttpClient httpClient1 = httpClient;
//
//        // Creating and returning the HttpComponentsClientHttpRequestFactory
//        return new HttpComponentsClientHttpRequestFactory((org.apache.hc.client5.http.classic.HttpClient) httpClient1);
//    }
//
//    @Override
//    public void customize(RestTemplate restTemplate) {
//        // Setting the custom ClientHttpRequestFactory to the RestTemplate
//        restTemplate.setRequestFactory(this.clientHttpRequestFactory());
//    }
//}