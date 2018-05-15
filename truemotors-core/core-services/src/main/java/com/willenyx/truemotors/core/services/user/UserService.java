package com.willenyx.truemotors.core.services.user;

import com.willenyx.truemotors.core.db.entities.User;

import javax.validation.constraints.NotNull;

/**
 * Author: William Arustamyan
 * Date: 14/05/2018
 * Time: 5:23 PM
 */
public interface UserService {

    User create(@NotNull UserCreateUpdateRequest createRequest);

    User get(long userId);

    User update(@NotNull UserCreateUpdateRequest updateRequest);

    void delete(long id);
}
