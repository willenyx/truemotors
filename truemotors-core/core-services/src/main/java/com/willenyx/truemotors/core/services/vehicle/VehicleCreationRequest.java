package com.willenyx.truemotors.core.services.vehicle;

import com.willenyx.truemotors.api.common.vehicle.*;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

/**
 * Author: William Arustamyan
 * Date: 18/05/2018
 * Time: 1:24 PM
 */
public class VehicleCreationRequest {

    @NotNull
    private Long markId;

    @NotNull
    private LocalDate vehicleDate;

    @NotNull
    private Integer mileage;

    @NotNull
    private Gearbox gearbox;

    @NotNull
    private HandDrive handDrive;

    @NotNull
    private EngineType engineType;

    @NotNull
    private Condition condition;

    @NotNull
    private String color;

    @NotNull
    private String options;

    @NotNull
    private String additionalInfo;

    @NotNull
    private Country country;

    @NotNull
    private Double price;

    public Long getMarkId() {
        return markId;
    }

    public void setMarkId(Long markId) {
        this.markId = markId;
    }

    public LocalDate getVehicleDate() {
        return vehicleDate;
    }

    public void setVehicleDate(LocalDate vehicleDate) {
        this.vehicleDate = vehicleDate;
    }

    public Integer getMileage() {
        return mileage;
    }

    public void setMileage(Integer mileage) {
        this.mileage = mileage;
    }

    public Gearbox getGearbox() {
        return gearbox;
    }

    public void setGearbox(Gearbox gearbox) {
        this.gearbox = gearbox;
    }

    public HandDrive getHandDrive() {
        return handDrive;
    }

    public void setHandDrive(HandDrive handDrive) {
        this.handDrive = handDrive;
    }

    public EngineType getEngineType() {
        return engineType;
    }

    public void setEngineType(EngineType engineType) {
        this.engineType = engineType;
    }

    public Condition getCondition() {
        return condition;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getOptions() {
        return options;
    }

    public void setOptions(String options) {
        this.options = options;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
