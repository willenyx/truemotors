package com.willenyx.truemotors.core.services.user;

import com.willenyx.truemotors.api.common.ServiceType;
import com.willenyx.truemotors.core.db.entities.User;
import com.willenyx.truemotors.core.db.repositories.UserRepository;
import com.willenyx.truemotors.core.services.CrudService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

/**
 * Author: William Arustamyan
 * Date: 14/05/2018
 * Time: 5:35 PM
 */
@Service
public class UserCrudService implements CrudService<User, UserCreationRequest, UserModificationRequest> {

    private static final Logger logger = LoggerFactory.getLogger(UserCrudService.class);

    @Autowired
    private UserRepository userRepository;

    //Todo: Investigate user create and update flow.
    @Override
    @Transactional
    public User create(@NotNull final UserCreationRequest request) {
        logger.trace("Creating User ...");
        this.validateCreationRequest(request);
        logger.trace("Done user create validation ...");
        User user = new User();
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setPhoneNumber(request.getPassword());
        User savedInstance = userRepository.save(user);
        logger.trace("User with id {}, created", savedInstance.getId());
        return savedInstance;
    }

    @Override
    @Transactional(readOnly = true)
    public User get(final long userId) {

        User found = userRepository.findByIdAndDeletedIsNull(userId);
        if (found == null) {
            throw new ResourceNotFoundException(String.format("User with id : %s not found", userId));
        }
        return found;
    }

    //Todo: Investigate user create and update flow.
    @Override
    @Transactional
    public User update(final long userId, @NotNull final UserModificationRequest updateRequest) {
        logger.trace("Updating user ");
        this.validateModificationRequest(updateRequest);
        logger.trace("Done user update validation ...");
        User found = userRepository.findByIdAndDeletedIsNull(userId);
        if (found != null) {
            found.setPhoneNumber(updateRequest.getPhoneNumber());
            found.setEmail(updateRequest.getEmail());
            found.setPassword(updateRequest.getPassword());
            User updatedInstance = userRepository.save(found);
            logger.trace("User with id {}, updated", updatedInstance.getId());
            return updatedInstance;
        }
        throw new ResourceNotFoundException(String.format("User with id : %s not found", userId));
    }

    @Override
    @Transactional
    public void delete(final long id) {
        logger.trace("Deleting User with id {} ...", id);
        User found = userRepository.findByIdAndDeletedIsNull(id);

        if (found == null) {
            throw new ResourceNotFoundException(String.format("User with id : %s not found", id));
        }

        found.setDeleted(LocalDateTime.now());

        userRepository.save(found);
        logger.info("Done deleting user with id : {} ", found.getId());

    }

    @Override
    public ServiceType getServiceType() {
        return ServiceType.USER;
    }

    private void validateCreationRequest(final UserCreationRequest request) {
        Assert.notNull(request, "User creation request cannot be null ...");
        Assert.notNull(request.getFirstName(), "User create or update request first name cannot be null ...");
        Assert.notNull(request.getLastName(), "User create or update request last name cannot be null ...");
        Assert.notNull(request.getEmail(), "User create or update request email address cannot be null ...");
        Assert.notNull(request.getPassword(), "User create or update request password cannot be null ...");
        Assert.notNull(request.getPhoneNumber(), "User create or update request phone number cannot be null ...");
    }

    private void validateModificationRequest(final UserModificationRequest request) {
        Assert.notNull(request, "User create or update request cannot be null ...");
        Assert.notNull(request.getEmail(), "User create or update request email address cannot be null ...");
        Assert.notNull(request.getPassword(), "User create or update request password cannot be null ...");
        Assert.notNull(request.getPhoneNumber(), "User create or update request phone number cannot be null ...");
    }

}
