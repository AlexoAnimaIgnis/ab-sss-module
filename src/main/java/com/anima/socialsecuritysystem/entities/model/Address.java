package com.anima.socialsecuritysystem.entities.model;

import com.anima.socialsecuritysystem.entities.BaseModel;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "USER_ADDRESS")
public class Address extends BaseModel<String> implements Serializable {


    private static final long serialVersionUID = -4147127560653703633L;
    @Id
    private Long id;
    @Column
    private String address_unit;
    @Column
    private String address_house;
    @Column
    private String address_street;
    @Column
    private String address_city;
    @Column
    private int postal_code;
    @ManyToOne
    private User user;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
