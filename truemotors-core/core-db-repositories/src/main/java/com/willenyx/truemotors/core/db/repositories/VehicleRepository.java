package com.willenyx.truemotors.core.db.repositories;

import com.willenyx.truemotors.core.db.entities.Vehicle;
import org.springframework.data.repository.CrudRepository;

/**
 * Author: William Arustamyan
 * Date: 18/05/2018
 * Time: 2:26 PM
 */
public interface VehicleRepository extends CrudRepository<Vehicle, Long> {

    Vehicle findByIdAndDeletedIsNull(Long userId);
}
