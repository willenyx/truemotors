package com.willenyx.truemotors.api.endpoints;

import com.willenyx.truemotors.api.common.ServiceType;
import com.willenyx.truemotors.api.common.user.UserResponseDto;
import com.willenyx.truemotors.api.config.BeanMapper;
import com.willenyx.truemotors.core.db.entities.User;
import com.willenyx.truemotors.core.services.ServiceRegistry;
import com.willenyx.truemotors.core.services.user.UserCreationRequest;
import com.willenyx.truemotors.core.services.user.UserCrudService;
import com.willenyx.truemotors.core.services.user.UserModificationRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Author: William Arustamyan
 * Date: 14/05/2018
 * Time: 5:58 PM
 */

@Component
@Path("/user")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserEndpoint {

    private static final Logger logger = LoggerFactory.getLogger(UserEndpoint.class);

    @Autowired
    private BeanMapper mapper;

    @Autowired
    private ServiceRegistry<UserCrudService> serviceRegistry;

    @PUT
    public UserResponseDto create(@NotNull final UserCreationRequest creationRequest) {
        Assert.notNull(creationRequest, "creationRequest cannot be null...");
        logger.info("Start creating user...");
        User createdUser = serviceRegistry.getService(ServiceType.USER).create(creationRequest);
        logger.info("Done creating user with id : {}", createdUser.getId());
        return mapper.map(createdUser, UserResponseDto.class);
    }

    @GET
    @Path("/{userId}")
    public UserResponseDto get(@NotNull @PathParam("userId") final Long userId) {
        Assert.notNull(userId, "userId cannot be null...");
        logger.debug("Getting user with id : {}", userId);
        User user = serviceRegistry.getService(ServiceType.USER).get(userId);
        logger.info("Done getting user with id : {}", user.getId());
        return mapper.map(user, UserResponseDto.class);
    }

    @PUT
    @Path("/{userId}")
    public UserResponseDto update(@NotNull @PathParam("userId") final Long userId, @NotNull @Valid final UserModificationRequest modificationRequest) {
        Assert.notNull(modificationRequest, "modificationRequest cannot be null...");
        User user = serviceRegistry.getService(ServiceType.USER).update(userId, modificationRequest);
        return mapper.map(user, UserResponseDto.class);
    }

    //Todo: Add generic application response.
    @DELETE
    @Path("/{userId}")
    public void delete(@NotNull @PathParam("userId") final Long userId) {
        Assert.notNull(userId, "userId cannot be empty");
        logger.debug("Deleting user:{}...", userId);
        serviceRegistry.getService(ServiceType.USER).delete(userId);
        logger.info("Deleted user:{}.", userId);
    }
}
