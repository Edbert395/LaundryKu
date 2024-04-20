package com.example.myapplication.menu.user;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class User extends RealmObject {
    @PrimaryKey
    private String email;
    private String password;

//    this attributes is additional, if wanna use it, just add the method
    private String fullName, phoneNumber, birthPlace, birthDate;

    // Getters and setters
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}
