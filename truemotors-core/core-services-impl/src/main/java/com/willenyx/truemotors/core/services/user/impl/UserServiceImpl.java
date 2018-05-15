package com.willenyx.truemotors.core.services.user.impl;

import com.willenyx.truemotors.core.db.entities.User;
import com.willenyx.truemotors.core.db.repositories.UserRepository;
import com.willenyx.truemotors.core.services.user.UserCreateUpdateRequest;
import com.willenyx.truemotors.core.services.user.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import javax.validation.constraints.NotNull;

/**
 * Author: William Arustamyan
 * Date: 14/05/2018
 * Time: 5:35 PM
 */
@Service
public class UserServiceImpl implements UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepository userRepository;

    //Todo: Investigate user create and update flow.
    @Override
    @Transactional
    public User create(@NotNull final UserCreateUpdateRequest createRequest) {
        logger.trace("Creating User ...");
        this.validateRequest(createRequest);
        logger.trace("Done user create validation ...");
        User user = this.initUser(createRequest);
        User savedInstance = userRepository.save(user);
        logger.trace("User with id {}, created", savedInstance.getId());
        return savedInstance;
    }

    @Override
    @Transactional(readOnly = true)
    public User get(final long userId) {
        return userRepository.findByIdAndDeletedIsNull(userId);
    }

    //Todo: Investigate user create and update flow.
    @Override
    @Transactional
    public User update(@NotNull final UserCreateUpdateRequest updateRequest) {
        logger.trace("Updating user ");
        this.validateRequest(updateRequest);
        logger.trace("Done user update validation ...");
        User user = this.initUser(updateRequest);
        User savedInstance = userRepository.save(user);
        logger.trace("User with id {}, updated", savedInstance.getId());
        return savedInstance;
    }

    @Override
    @Transactional
    public void delete(final long id) {
        logger.trace("Deleting User with id {} ...", id);
    }

    private User initUser(UserCreateUpdateRequest request) {
        User user = new User();
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setPhoneNumber(request.getPassword());
        return user;
    }

    private void validateRequest(final UserCreateUpdateRequest request) {
        Assert.notNull(request, "User create or update request cannot be null ...");
        Assert.notNull(request.getFirstName(), "User create or update request first name cannot be null ...");
        Assert.notNull(request.getLastName(), "User create or update request last name cannot be null ...");
        Assert.notNull(request.getEmail(), "User create or update request email address cannot be null ...");
        Assert.notNull(request.getPassword(), "User create or update request password cannot be null ...");
        Assert.notNull(request.getPhoneNumber(), "User create or update request phone number cannot be null ...");
    }
}
