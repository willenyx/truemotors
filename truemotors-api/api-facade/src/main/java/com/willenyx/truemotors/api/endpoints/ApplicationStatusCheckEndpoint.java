package com.willenyx.truemotors.api.endpoints;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Author: William Arustamyan
 * Date: 14/05/2018
 * Time: 3:08 PM
 */
@Component
@Path("/status")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ApplicationStatusCheckEndpoint {

    private static final Logger logger = LoggerFactory.getLogger(ApplicationStatusCheckEndpoint.class);

    @GET
    public Response.Status status() {
        logger.info("Health-check performed successfully");
        return Response.Status.OK;
    }
}
