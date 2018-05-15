package com.willenyx.truemotors.api.endpoints;

import com.willenyx.truemotors.api.common.user.UserCreateUpdateRequestDto;
import com.willenyx.truemotors.api.common.user.UserResponseDto;
import com.willenyx.truemotors.api.config.BeanMapper;
import com.willenyx.truemotors.core.db.entities.User;
import com.willenyx.truemotors.core.services.user.UserCreateUpdateRequest;
import com.willenyx.truemotors.core.services.user.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
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
    private UserService userService;

    @PUT
    public UserResponseDto create(@NotNull final UserCreateUpdateRequestDto createUpdateRequest) {
        Assert.notNull(createUpdateRequest, "createUpdateRequest cannot be null...");
        logger.info("Start creating user...");
        UserCreateUpdateRequest request = mapper.map(createUpdateRequest, UserCreateUpdateRequest.class);
        User createdUser = userService.create(request);
        logger.info("Done creating user with id : {}", createdUser.getId());
        return mapper.map(createdUser, UserResponseDto.class);
    }
}
