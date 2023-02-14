package com.example.cybernet;

public class User {

    public String fullName, email, age, profilePicture;

    public User(){

    }

    public User(String fullName, String email, String age, String profilePicture){
        this.fullName = fullName;
        this.email = email;
        this.age = age;
        this.profilePicture = profilePicture;


    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }



    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }
}
