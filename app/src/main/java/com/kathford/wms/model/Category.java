package com.kathford.wms.model;

import java.util.Date;

import lombok.Data;

@Data
public class Category {

    private Long id;

    private String name;

    private boolean status;

    private Admin createdBy;

    private Admin modifiedBy;

    private Date createdDate;

    private Date modifiedDate;
}
