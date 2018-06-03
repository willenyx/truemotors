package com.willenyx.truemotors.core.services;

import com.willenyx.truemotors.api.common.ServiceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.EnumMap;
import java.util.Map;
import java.util.Set;

/**
 * Author: William Arustamyan
 * Date: 18/05/2018
 * Time: 1:45 PM
 */

@Service
public class ServiceRegistryImpl implements ServiceRegistry {

    private final Map<ServiceType, CrudService> registry;

    @Autowired
    public ServiceRegistryImpl(final Set<CrudService> services) {
        registry = new EnumMap<>(ServiceType.class);
        services.forEach(it -> registry.put(it.getServiceType(), it));
    }

    @Override
    public CrudService<?, ?, ?> getService(ServiceType serviceType) {
        return this.registry.get(serviceType);
    }
}
