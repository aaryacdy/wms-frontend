package com.kathford.wms.model;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class Waste extends BaseModel {
    
    private String name;

    private BigDecimal weight;

    private BigDecimal price;

    private String address;

    private String location;

    private String status; //only updated by the driver or collector

    private Category wastageType;
}
