package com.willenyx.truemotors.api.config;

import org.glassfish.jersey.servlet.ServletContainer;
import org.glassfish.jersey.servlet.ServletProperties;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Author: William Arustamyan
 * Date: 14/05/2018
 * Time: 2:56 PM
 */
@Configuration
public class ServletRegistrationManager {

    @Value("${server.servlet.context-path}")
    private String serverServletContextPath;

    @Bean
    public ServletRegistrationBean<ServletContainer> jerseyServlet() {
        // Create registration bean
        final ServletRegistrationBean<ServletContainer> servletRegistrationBean = new ServletRegistrationBean<>();

        servletRegistrationBean.setServlet(new ServletContainer());
        servletRegistrationBean.setName("servlet.jersey");
        servletRegistrationBean.getUrlMappings().add(serverServletContextPath + "/*");
        servletRegistrationBean.setOrder(0);
        servletRegistrationBean.addInitParameter(ServletProperties.JAXRS_APPLICATION_CLASS, TrueMotorsJerseyConfig.class.getName());

        return servletRegistrationBean;
    }
}
