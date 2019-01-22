package com.vilderlee.clone;

import java.io.Serializable;

/**
 * <pre>
 * Modify Information:
 * Author        Date          Description
 * ============ ============= ============================
 * VilderLee    2019/1/21      Create this file
 * </pre>
 */
public class User implements Serializable, Cloneable {

    private static final long serialVersionUID = -7273111370871749479L;

    public User() {
    }

    public User(String userId, String userName, String country) {
        this.userId = userId;
        this.userName = userName;
        this.country = country;
    }

    private String userId;
    private String userName;
    private String country;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override public String toString() {
        return "User{" + "userId='" + userId + '\'' + ", userName='" + userName + '\'' + ", country='" + country + '\'' + '}';
    }

    @Override protected User clone() throws CloneNotSupportedException {
        User user = null;
        user = (User) super.clone();

        return user;
    }
}