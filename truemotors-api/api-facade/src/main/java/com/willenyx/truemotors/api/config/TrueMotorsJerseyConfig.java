package com.willenyx.truemotors.api.config;

import com.willenyx.truemotors.api.endpoints.ApplicationStatusCheckEndpoint;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

/**
 * Author: William Arustamyan
 * Date: 14/05/2018
 * Time: 3:16 PM
 */
@Component
public class TrueMotorsJerseyConfig extends ResourceConfig {
    public TrueMotorsJerseyConfig() {
        //register endpoints here
        register(ApplicationStatusCheckEndpoint.class);
    }
}