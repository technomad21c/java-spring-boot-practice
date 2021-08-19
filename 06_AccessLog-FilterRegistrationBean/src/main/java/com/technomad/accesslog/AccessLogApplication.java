package com.technomad.accesslog;

import org.apache.catalina.valves.AccessLogValve;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.autoconfigure.web.embedded.TomcatWebServerFactoryCustomizer;
import org.springframework.boot.autoconfigure.web.servlet.TomcatServletWebServerFactoryCustomizer;
import org.springframework.boot.web.embedded.tomcat.TomcatContextCustomizer;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.env.Environment;
import org.springframework.web.filter.RequestContextFilter;

@SpringBootApplication
public class AccessLogApplication {

    @Bean
    public WebServerFactoryCustomizer webServerFactoryCustomizer() {
        return factory -> {
            if (factory instanceof TomcatServletWebServerFactory) {
                AccessLogValve valve = new AccessLogValve();
                valve.setDirectory("logs");
                valve.setPrefix("access");
                valve.setSuffix(".log");
                valve.setPattern("%{X-Forwarded-For}i %h %l %u %t \"%r\" %s %b");

                ((TomcatServletWebServerFactory) factory).addEngineValves(valve);
            }
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(AccessLogApplication.class, args);
    }
}
