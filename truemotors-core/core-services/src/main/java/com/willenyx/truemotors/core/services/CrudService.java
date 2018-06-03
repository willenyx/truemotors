package com.willenyx.truemotors.core.services;

import com.willenyx.truemotors.api.common.ServiceType;

/**
 * Author: William Arustamyan
 * Date: 18/05/2018
 * Time: 1:21 PM
 */
public interface CrudService<E, CR, MR> {

    E create(CR creationRequest);

    E get(long id);

    E update(long id, MR modificationRequest);

    void delete(long id);

    ServiceType getServiceType();
}
