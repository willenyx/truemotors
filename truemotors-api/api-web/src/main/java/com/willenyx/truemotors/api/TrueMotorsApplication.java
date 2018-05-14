package com.willenyx.truemotors.api;

import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jersey.JerseyAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ImportResource;

/**
 * Author: William Arustamyan
 * Date: 14/05/2018
 * Time: 2:45 PM
 */

@ImportResource("classpath:/com/willenyx/truemotors/truemotors-api-web-context.xml")
@SpringBootApplication
@EnableAutoConfiguration(exclude = {JerseyAutoConfiguration.class})
public class TrueMotorsApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(TrueMotorsApplication.class)
                .bannerMode(Banner.Mode.OFF)
                .run(args);
    }
}
