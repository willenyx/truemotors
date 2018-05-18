package com.willenyx.truemotors.core.db.entities;

import com.willenyx.truemotors.api.common.vehicle.*;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Author: William Arustamyan
 * Date: 18/05/2018
 * Time: 11:38 AM
 */

@Entity
@Table(name = "vehicle")
public class Vehicle {

    @Id
    @SequenceGenerator(name = "seq_vehicle", sequenceName = "seq_vehicle")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_vehicle")
    @Column(name = "id", unique = true, nullable = false, updatable = false)
    private Long id;

    @OneToOne
    @JoinColumn(name = "mark_id", referencedColumnName = "id")
    private Mark mark;

    @Column(name = "vehicle_date", nullable = false)
    private LocalDate vehicleDate;

    @Column(name = "mileage", nullable = false)
    private int mileage;

    @Enumerated(EnumType.STRING)
    @Column(name = "gear_box", nullable = false)
    private Gearbox gearbox;

    @Enumerated(EnumType.STRING)
    @Column(name = "hand_drive", nullable = false)
    private HandDrive handDrive;

    @Enumerated(EnumType.STRING)
    @Column(name = "engine_type", nullable = false)
    private EngineType engineType;

    @Enumerated(EnumType.STRING)
    @Column(name = "condition", nullable = false)
    private Condition condition;

    @Column(name = "color", nullable = false)
    private String color;

    //Todo: review this.
    @Column(name = "options", nullable = false)
    private String options;

    @Column(name = "additional_info", nullable = false)
    private String additionalInfo;

    @Enumerated(EnumType.STRING)
    @Column(name = "country", nullable = false)
    private Country country;

    @Column(name = "price", nullable = false)
    private double price;

    @Column(name = "created", nullable = false)
    private LocalDateTime created;

    @Column(name = "updated", nullable = false)
    private LocalDateTime updated;

    @Column(name = "deleted", nullable = true)
    private LocalDateTime deleted;

    @PrePersist
    protected void onCreate() {
        this.created = LocalDateTime.now();
        this.updated = created;
    }

    @PreUpdate
    protected void onUpdate() {
        this.updated = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Mark getMark() {
        return mark;
    }

    public void setMark(Mark mark) {
        this.mark = mark;
    }

    public LocalDate getVehicleDate() {
        return vehicleDate;
    }

    public void setVehicleDate(LocalDate vehicleDate) {
        this.vehicleDate = vehicleDate;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getUpdated() {
        return updated;
    }

    public void setUpdated(LocalDateTime updated) {
        this.updated = updated;
    }

    public LocalDateTime getDeleted() {
        return deleted;
    }

    public void setDeleted(LocalDateTime deleted) {
        this.deleted = deleted;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Vehicle vehicle = (Vehicle) o;

        return new EqualsBuilder()
                .append(id, vehicle.id)
                .append(mark, vehicle.mark)
                .append(vehicleDate, vehicle.vehicleDate)
                .append(mileage, vehicle.mileage)
                .append(gearbox, vehicle.gearbox)
                .append(handDrive, vehicle.handDrive)
                .append(engineType, vehicle.engineType)
                .append(condition, vehicle.condition)
                .append(color, vehicle.color)
                .append(options, vehicle.options)
                .append(additionalInfo, vehicle.additionalInfo)
                .append(country, vehicle.country)
                .append(price, vehicle.price)
                .append(created, vehicle.created)
                .append(updated, vehicle.updated)
                .append(deleted, vehicle.deleted)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(id)
                .append(mark)
                .append(vehicleDate)
                .append(mileage)
                .append(gearbox)
                .append(handDrive)
                .append(engineType)
                .append(condition)
                .append(color)
                .append(options)
                .append(additionalInfo)
                .append(country)
                .append(price)
                .append(created)
                .append(updated)
                .append(deleted)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("mark", mark)
                .append("vehicleDate", vehicleDate)
                .append("mileage", mileage)
                .append("gearbox", gearbox)
                .append("handDrive", handDrive)
                .append("engineType", engineType)
                .append("condition", condition)
                .append("color", color)
                .append("options", options)
                .append("additionalInfo", additionalInfo)
                .append("country", country)
                .append("price", price)
                .append("created", created)
                .append("updated", updated)
                .append("deleted", deleted)
                .toString();
    }
}
