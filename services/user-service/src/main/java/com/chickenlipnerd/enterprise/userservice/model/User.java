package com.chickenlipnerd.enterprise.userservice.model;

import com.chickenlipnerd.enterprise.shared.persistence.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "app_user")
public class User extends BaseEntity {

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false, unique = true)
    private String emailAddress;

    @Column(nullable = false)
    private String status;

    protected User() {
    }

    public User(String username, String emailAddress, String status) {
        this.username = username;
        this.emailAddress = emailAddress;
        this.status = status;
    }

    public String getUsername() {
        return username;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getStatus() {
        return status;
    }
}
