package com.example.interceptor.config;

import com.example.interceptor.interceptor.ProductServiceInterceptor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Component
public class ProductServiceInterceptorConfig implements WebMvcConfigurer {
//    @Autowired
//    ProductServiceInterceptor productServiceInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
            registry.addInterceptor(new ProductServiceInterceptor());
    }
}
