package com.willenyx.truemotors.core.services;

import com.willenyx.truemotors.api.common.ServiceType;

/**
 * Author: William Arustamyan
 * Date: 18/05/2018
 * Time: 1:43 PM
 */

public interface ServiceRegistry<S extends CrudService<?, ?, ?>> {

    S getService(ServiceType serviceType);
}
