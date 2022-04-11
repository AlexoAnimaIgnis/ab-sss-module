package com.anima.socialsecuritysystem.entities;

import java.util.Date;

public class BaseModel<T> {
    
    private String createdBy;
    private Date createdDate;
    private String modifiedBy;
    private Date modifiedDate;
    private boolean deleted;
}
