package com.technomad.accesslog.valve;

import org.apache.catalina.valves.AccessLogValve;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.stereotype.Component;

//@Component
public class TomcatWebServerAccessLogCustomizer { // implements WebServerFactoryCustomizer<TomcatServletWebServerFactory> {
    @Autowired
    ServerProperties serverProperties;

//    @Override
    public void customize(TomcatServletWebServerFactory factory) {
        ServerProperties.Tomcat tomcatProperties = serverProperties.getTomcat();

        AccessLogValve valve = new AccessLogValve();
        valve.setDirectory("logs");
        valve.setPrefix("access");
        valve.setSuffix(".log");
        valve.setPattern("%{X-Forwarded-For}i %h %l %u %t \"%r\" %s %b");

        factory.addEngineValves(valve);
    }
}
