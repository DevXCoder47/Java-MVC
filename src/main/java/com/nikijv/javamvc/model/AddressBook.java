package com.nikijv.javamvc.model;

public class AddressBook {
    private String credentials;
    private String phoneNumber;
    private String email;
    private String blogReference;
    private String notes;

    public AddressBook() {}

    public AddressBook(String credentials, String phoneNumber, String email, String blogReference, String notes) {
        this.credentials = credentials;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.blogReference = blogReference;
        this.notes = notes;
    }

    public String getCredentials() {
        return credentials;
    }

    public void setCredentials(String credentials) {
        this.credentials = credentials;
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

    public String getBlogReference() {
        return blogReference;
    }

    public void setBlogReference(String blogReference) {
        this.blogReference = blogReference;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
