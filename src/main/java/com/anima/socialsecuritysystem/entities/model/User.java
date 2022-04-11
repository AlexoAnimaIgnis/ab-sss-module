package com.anima.socialsecuritysystem.entities.model;

import com.anima.socialsecuritysystem.entities.BaseModel;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Data
@Entity
@Table(name ="SSS_USER")
public class User extends BaseModel<String> implements Serializable {

    private static final long serialVersionUID = 5438544613984280218L;

    @Id
    @Column(name="SSS_ID")
    private Long id;

    @Column
    private String firstname;
    @Column
    private String middlename;
    @Column
    private String lastname;
    @Column
    private String suffix;
    @Column
    private Date dateOfBirth;
    @Column
    private String contactNumber;
    @Column
    private String email;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstname, middlename, lastname, suffix, dateOfBirth, contactNumber, email);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id.equals(user.id) && Objects.equals(firstname, user.firstname) && Objects.equals(middlename, user.middlename) && lastname.equals(user.lastname) && Objects.equals(contactNumber, user.contactNumber);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", middlename='" + middlename + '\'' +
                ", lastname='" + lastname + '\'' +
                ", suffix='" + suffix + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", contactNumber='" + contactNumber + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
