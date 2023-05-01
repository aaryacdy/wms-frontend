package com.kathford.wms.model;

import lombok.Data;

@Data
public class Complaint extends BaseModel {

    private String complaint;

    private String status;

}