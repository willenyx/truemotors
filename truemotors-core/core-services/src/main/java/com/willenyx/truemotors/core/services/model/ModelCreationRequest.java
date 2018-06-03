package com.willenyx.truemotors.core.services.model;

import com.willenyx.truemotors.api.common.vehicle.BodyType;

import javax.validation.constraints.NotNull;

/**
 * Author: William Arustamyan
 * Date: 18/05/2018
 * Time: 1:26 PM
 */
public class ModelCreationRequest {

    @NotNull
    private String modelName;

    @NotNull
    private BodyType bodyType;

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public BodyType getBodyType() {
        return bodyType;
    }

    public void setBodyType(BodyType bodyType) {
        this.bodyType = bodyType;
    }
}
