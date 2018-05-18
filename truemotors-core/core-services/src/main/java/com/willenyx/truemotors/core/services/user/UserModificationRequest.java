package com.willenyx.truemotors.core.services.user;

/**
 * Author: William Arustamyan
 * Date: 18/05/2018
 * Time: 9:22 AM
 */
public class UserModificationRequest {

    private String password;

    private String phoneNumber;

    private String email;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
