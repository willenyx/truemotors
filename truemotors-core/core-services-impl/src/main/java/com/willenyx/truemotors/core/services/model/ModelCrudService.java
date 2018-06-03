package com.willenyx.truemotors.core.services.model;

import com.willenyx.truemotors.api.common.ServiceType;
import com.willenyx.truemotors.core.db.entities.Model;
import com.willenyx.truemotors.core.db.repositories.MarkRepository;
import com.willenyx.truemotors.core.db.repositories.ModelRepository;
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
public class ModelCrudService implements CrudService<Model, ModelCreationRequest, ModelModificationRequest> {

    @Autowired
    private ModelRepository modelRepository;

    @Autowired
    private MarkRepository markRepository;

    @Override
    public Model create(@NotNull final ModelCreationRequest creationRequest) {

        final Model model = new Model();

        model.setBodyType(creationRequest.getBodyType());
        model.setModelName(creationRequest.getModelName());

        return null;
    }

    @Override
    public Model get(final long id) {
        return null;
    }

    @Override
    public Model update(final long modelId, @NotNull final ModelModificationRequest modificationRequest) {
        return null;
    }

    @Override
    public void delete(final long id) {

    }

    @Override
    public ServiceType getServiceType() {
        return ServiceType.MODEL;
    }
}
