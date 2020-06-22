package com.code.challenge.shipping.models;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity(name = "shipping_options")
public class Option implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty(message = "The shipping option name cannot be empty")
    private String name;

    @NotEmpty(message = "The shipping option type cannot be empty")
    private String type;

    @NotNull(message = "The shipping option cost cannot be empty")
    @Digits(message = "The shipping option cost must be a number", integer = 9, fraction = 2)
    private BigDecimal cost;

    @NotNull(message = "The shipping option estimated delivery days cannot be empty")
    @Digits(message = "The shipping option estimated delivery days must be a number", integer = 9, fraction = 0)
    @JsonProperty("estimated_delivery_days")
    @Column(name = "estimated_delivery_days")
    private Long estimatedDeliveryDays;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public Long getEstimatedDeliveryDays() {
        return estimatedDeliveryDays;
    }

    public void setEstimatedDelivery(Long estimatedDeliveryDays) {
        this.estimatedDeliveryDays = estimatedDeliveryDays;
    }
}
