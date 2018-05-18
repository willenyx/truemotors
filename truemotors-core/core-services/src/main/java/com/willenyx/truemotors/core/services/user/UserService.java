package com.willenyx.truemotors.core.services.user;

import com.willenyx.truemotors.core.db.entities.User;

import javax.validation.constraints.NotNull;

/**
 * Author: William Arustamyan
 * Date: 14/05/2018
 * Time: 5:23 PM
 */
public interface UserService {

    User create(@NotNull UserCreationRequest request);

    User get(long userId);

    User update(long userId, @NotNull UserModificationRequest updateRequest);

    void delete(long id);
}
