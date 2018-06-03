package com.willenyx.truemotors.core.services.mark;

import javax.validation.constraints.NotNull;

/**
 * Author: William Arustamyan
 * Date: 18/05/2018
 * Time: 1:26 PM
 */
public class MarkModificationRequest {

    @NotNull
    private String markName;

    public String getMarkName() {
        return markName;
    }

    public void setMarkName(String markName) {
        this.markName = markName;
    }
}
