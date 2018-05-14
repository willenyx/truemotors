package com.willenyx.truemotors.core.db.repositories;

import com.willenyx.truemotors.core.db.entities.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Author: William Arustamyan
 * Date: 14/05/2018
 * Time: 5:17 PM
 */
public interface UserRepository extends CrudRepository<User, Long> {
}
