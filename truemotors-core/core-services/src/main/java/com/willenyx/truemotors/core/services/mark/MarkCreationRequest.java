package com.willenyx.truemotors.core.services.mark;

import com.willenyx.truemotors.core.services.model.ModelCreationRequest;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Set;

/**
 * Author: William Arustamyan
 * Date: 18/05/2018
 * Time: 1:25 PM
 */
public class MarkCreationRequest {

    @NotNull
    private String markName;

    @NotEmpty
    @NotNull
    private Set<ModelCreationRequest> models;

    public String getMarkName() {
        return markName;
    }

    public void setMarkName(String markName) {
        this.markName = markName;
    }

    public Set<ModelCreationRequest> getModels() {
        return models;
    }

    public void setModels(Set<ModelCreationRequest> models) {
        this.models = models;
    }
}
