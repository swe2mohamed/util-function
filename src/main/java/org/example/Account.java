package org.example;

import java.time.LocalDate;

public class Account {
    private String username;
    private Role role;
    private LocalDate createDate;
    private boolean enable;

    public Account(String username) {
        this.username = username;
        this.createDate = LocalDate.now(); // We want to do it manually
        // this.enable = false; // by default is false so we di not need to write it
        this.role = Role.GUEST; // default value we choose is a GUEST
    }

    public void setRole(Role role) {
        if (role == null) throw new IllegalArgumentException("Role should not be null.");
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public Role getRole() {
        return role;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public boolean isEnable() {
        return enable;
    }

    public void enable(){
        this.enable = true;
    }

    public void disable(){
        this.enable = false;
    }

    @Override
    public String toString() {
        return "Account{" +
                "username='" + username + '\'' +
                ", role=" + role +
                ", createDate=" + createDate +
                ", enable=" + enable +
                '}';
    }
}
