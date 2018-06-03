package com.willenyx.truemotors.core.db.repositories;

import com.willenyx.truemotors.core.db.entities.Mark;
import org.springframework.data.repository.CrudRepository;

/**
 * Author: William Arustamyan
 * Date: 18/05/2018
 * Time: 2:25 PM
 */
public interface MarkRepository extends CrudRepository<Mark, Long> {
    Mark findByIdAndDeletedIsNull(Long markId);
}
