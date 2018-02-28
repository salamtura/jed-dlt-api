package com.jedc.apps.entities;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

/**
 * Created by BRAINERGY SOLUTIONS on 1/4/2018.
 */
@Entity
public class Users {
    private Integer id;
    private Integer firstname;
    private Integer lastname;
    private Integer middlename;
    private String mobile;
    private String username;
    private String password;
    private Date dateCreated;
    private Collection<UserRoles> userRolesById;

    public Users() {
    }

    public Users(Users user) {
        this.id = user.id;
        this.firstname = user.firstname;
        this.lastname = user.lastname;
        this.middlename = user.middlename;
        this.mobile = user.mobile;
        this.username = user.username;
        this.password = user.password;
        this.dateCreated = user.dateCreated;
    }

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "firstname", nullable = false)
    public Integer getFirstname() {
        return firstname;
    }

    public void setFirstname(Integer firstname) {
        this.firstname = firstname;
    }

    @Basic
    @Column(name = "lastname", nullable = false)
    public Integer getLastname() {
        return lastname;
    }

    public void setLastname(Integer lastname) {
        this.lastname = lastname;
    }

    @Basic
    @Column(name = "middlename", nullable = false)
    public Integer getMiddlename() {
        return middlename;
    }

    public void setMiddlename(Integer middlename) {
        this.middlename = middlename;
    }

    @Basic
    @Column(name = "mobile", nullable = false, length = 30)
    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Basic
    @Column(name = "username", nullable = false, length = 80)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "password", nullable = false, length = 120)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "date_created", nullable = false)
    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Users users = (Users) o;

        if (id != null ? !id.equals(users.id) : users.id != null) return false;
        if (firstname != null ? !firstname.equals(users.firstname) : users.firstname != null) return false;
        if (lastname != null ? !lastname.equals(users.lastname) : users.lastname != null) return false;
        if (middlename != null ? !middlename.equals(users.middlename) : users.middlename != null) return false;
        if (mobile != null ? !mobile.equals(users.mobile) : users.mobile != null) return false;
        if (username != null ? !username.equals(users.username) : users.username != null) return false;
        if (password != null ? !password.equals(users.password) : users.password != null) return false;
        if (dateCreated != null ? !dateCreated.equals(users.dateCreated) : users.dateCreated != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (firstname != null ? firstname.hashCode() : 0);
        result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
        result = 31 * result + (middlename != null ? middlename.hashCode() : 0);
        result = 31 * result + (mobile != null ? mobile.hashCode() : 0);
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (dateCreated != null ? dateCreated.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "usersByUserId")
    public Collection<UserRoles> getUserRolesById() {
        return userRolesById;
    }

    public void setUserRolesById(Collection<UserRoles> userRolesById) {
        this.userRolesById = userRolesById;
    }
}
