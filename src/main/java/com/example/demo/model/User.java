package com.example.demo.model;

import com.github.ankurpathak.password.bean.constraints.*;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "users_table")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long userID;

    @Column(name = "userName",nullable = false)
    @Size(min = 2, max = 15)
    private String userName;

    @Column(name = "userLastName",nullable = false)
    @Size(min = 2, max = 25)
    private String lastName;

    @Column(name = "userEmail", nullable = false, unique = true)
    private String userEmail;

    @Column(name = "phone_number", nullable = false, unique = true)
    private Long phoneNumber;

    @Column(name = "user_password", nullable = false, unique = true)
    @Size(min = 8)
    @NotContainWhitespace
    @ContainDigit
    @ContainLowercase
    @ContainUppercase
    private String password;

    public User(String userName, String lastName, String userEmail, Long phoneNumber, String password,String confirmPassword) {
        this.userName = userName;
        this.lastName = lastName;
        this.userEmail = userEmail;
        this.phoneNumber = phoneNumber;
        this.password = password;
    }

    public User(){}

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "userID=" + userID +
                ", name='" + userName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", password='" + password + '\'' +
                '}';
    }

    public boolean equals(User user) {
        return this.getUserEmail().equals(user.getUserEmail()) && this.getPassword().equals(user.getPassword());
    }


}
