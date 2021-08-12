package com.example.demo.model;

import com.github.ankurpathak.password.bean.constraints.ContainDigit;
import com.github.ankurpathak.password.bean.constraints.ContainLowercase;
import com.github.ankurpathak.password.bean.constraints.ContainUppercase;
import com.github.ankurpathak.password.bean.constraints.NotContainWhitespace;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long userID;

    @Column(name = "username", nullable = false)
    @Size(min = 2, max = 15)
    private String userName;

    @Column(name = "lastname", nullable = false)
    @Size(min = 2, max = 25)
    private String lastName;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "phone_number", nullable = false, unique = true)
    private Long phoneNumber;

    @Column(name = "password", nullable = false, unique = true)
    @Size(min = 8)
    @NotContainWhitespace
    @ContainDigit
    @ContainLowercase
    @ContainUppercase
    private String password;

    public User(String userName, String lastName, String email, Long phoneNumber, String password) {
        this.userName = userName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
    }

    public User() {
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
                ", userEmail='" + email + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", password='" + password + '\'' +
                '}';
    }
}
