package com.willenyx.truemotors.core.db.repositories;

import com.willenyx.truemotors.core.db.entities.Mark;
import com.willenyx.truemotors.core.db.entities.Model;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

/**
 * Author: William Arustamyan
 * Date: 18/05/2018
 * Time: 2:25 PM
 */
public interface ModelRepository extends CrudRepository<Model, Long> {

    Model findByIdAndDeletedIsNull(Long userId);

    Set<Model> findByMarkAndDeletedIsNull(Mark mark);
}
