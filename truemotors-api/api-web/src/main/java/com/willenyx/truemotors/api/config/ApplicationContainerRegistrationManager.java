package com.willenyx.truemotors.api.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.embedded.jetty.JettyServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Author: William Arustamyan
 * Date: 14/05/2018
 * Time: 2:53 PM
 */

@Configuration
public class ApplicationContainerRegistrationManager {

    @Value("${server.port}")
    private int serverPort;

    @Value("$server.servlet.application-display-name")
    private String serverDisplayName;

    private static final Logger logger = LoggerFactory.getLogger(ApplicationContainerRegistrationManager.class);

    @Bean
    public JettyServletWebServerFactory registerServletContainer() {
        logger.debug("Initializing Jetty embedded servlet container");
        final JettyServletWebServerFactory jettyServletWebServerFactory = new JettyServletWebServerFactory();
        jettyServletWebServerFactory.setDisplayName(serverDisplayName);
        jettyServletWebServerFactory.setPort(serverPort);
        return jettyServletWebServerFactory;
    }
}
