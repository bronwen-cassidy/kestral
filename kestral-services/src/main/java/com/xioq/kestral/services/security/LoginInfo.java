package com.xioq.kestral.services.security;

import org.hibernate.annotations.Type;

import javax.persistence.*;

/**
 * Created by bronwen.cassidy on 03/06/2015.
 * LoginInfo contains links to a user which could be a client or a provider
 */
@Entity
@Table(name = "logins")
public class LoginInfo {

    @Id
    @Column(name="user_id", nullable=false)
    private Long id;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;

    @Column(name = "is_active", nullable = false)
    @Type(type="yes_no")
    private boolean active = true;

    @Column(name = "failed_login_attempts", columnDefinition = "int default 0")
    private int failedLoginAttempts = 0;

    @OneToOne
    @PrimaryKeyJoinColumn
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public LoginInfo() {
    }

    public LoginInfo(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public int getFailedLoginAttempts() {
        return failedLoginAttempts;
    }

    public void setFailedLoginAttempts(int failedLoginAttempts) {
        this.failedLoginAttempts = failedLoginAttempts;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
        this.id = user.getId();
    }
}
