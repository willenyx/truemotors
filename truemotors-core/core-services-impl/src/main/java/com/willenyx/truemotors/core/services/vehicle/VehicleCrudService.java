package com.willenyx.truemotors.core.services.vehicle;

import com.willenyx.truemotors.api.common.ServiceType;
import com.willenyx.truemotors.core.db.entities.Vehicle;
import com.willenyx.truemotors.core.db.repositories.VehicleRepository;
import com.willenyx.truemotors.core.services.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;

/**
 * Author: William Arustamyan
 * Date: 18/05/2018
 * Time: 1:29 PM
 */

@Service
public class VehicleCrudService implements CrudService<Vehicle, VehicleCreationRequest, VehicleModificationRequest> {

    @Autowired
    private VehicleRepository vehicleRepository;

    @Override
    public Vehicle create(@NotNull final VehicleCreationRequest creationRequest) {
        return null;
    }

    @Override
    public Vehicle get(final long id) {
        return null;
    }

    @Override
    public Vehicle update(final long vehicleId, @NotNull final VehicleModificationRequest modificationRequest) {
        return null;
    }

    @Override
    public void delete(final long id) {

    }

    @Override
    public ServiceType getServiceType() {
        return ServiceType.VEHICLE;
    }
}
