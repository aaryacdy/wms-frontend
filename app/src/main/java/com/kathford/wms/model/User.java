package com.kathford.wms.model;

import java.util.Date;

import lombok.Data;

@Data
public class User {

    private Long id;

    private String name;

    private String salt;

    private String username;

    private String password;

    private String email;

    private String type;  // eg : driver / collector or user/client/general public

    private boolean blocked;

    private boolean status;

    private Date createdDate;

    private Date modifiedDate;
}
