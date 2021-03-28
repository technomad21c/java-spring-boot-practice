package com.example.interceptor.application;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;

import java.net.InetAddress;
import java.net.UnknownHostException;


@SpringBootApplication(scanBasePackages={"com.example.interceptor"})
public class LogbackApplication implements CommandLineRunner {

    private static Logger logger = LoggerFactory.getLogger(LogbackApplication.class);

    @Autowired
    private Environment env;

    @Autowired
    private ApplicationContext context;

    public static void main(String[] args) {
        logger.info("STARTING THE APPLICATION");
        SpringApplication.run(LogbackApplication.class, args);
        logger.info("APPLICATION  FINISHED");
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Logback Application is running...");
        System.out.println("Environment: " + env.toString());
        logger.debug("EXECUTING command line runner....");
        logger.debug("1 2 3 4 5 6 7 8 9 10");

        String hostName = "Unknown";
        try {
            hostName = InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException e) {
            logger.warn("Unable to resolve host name", e);
        }

        System.setProperty("qmci.host.name", hostName);

        logger.debug("host name: " + hostName);
    }
}
