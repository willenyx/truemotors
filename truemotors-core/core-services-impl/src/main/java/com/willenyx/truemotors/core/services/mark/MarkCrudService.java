package com.willenyx.truemotors.core.services.mark;

import com.willenyx.truemotors.api.common.ServiceType;
import com.willenyx.truemotors.core.db.entities.Mark;
import com.willenyx.truemotors.core.db.repositories.MarkRepository;
import com.willenyx.truemotors.core.db.repositories.ModelRepository;
import com.willenyx.truemotors.core.services.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.validation.constraints.NotNull;

/**
 * Author: William Arustamyan
 * Date: 18/05/2018
 * Time: 1:28 PM
 */
@Service
public class MarkCrudService implements CrudService<Mark, MarkCreationRequest, MarkModificationRequest> {

    @Autowired
    private MarkRepository markRepository;

    @Autowired
    private ModelRepository modelRepository;

    @Override
    public Mark create(@NotNull final MarkCreationRequest creationRequest) {
        Assert.notNull(creationRequest, "Mark creation request cannot be null ...");
        final Mark mark = new Mark();
        mark.setMarkName(creationRequest.getMarkName());
        mark.setModels(modelRepository.findByMarkAndDeletedIsNull(mark));
        return markRepository.save(mark);
    }

    @Override
    public Mark get(final long id) {
        return null;
    }

    @Override
    public Mark update(final long markId, @NotNull final MarkModificationRequest modificationRequest) {
        return null;
    }

    @Override
    public void delete(final long id) {

    }

    @Override
    public ServiceType getServiceType() {
        return ServiceType.MARK;
    }
}
