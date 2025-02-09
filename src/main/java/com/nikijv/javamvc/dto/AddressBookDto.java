package com.nikijv.javamvc.dto;

public class AddressBookDto {
    private String credentials;
    private String email;
    private String blogReference;

    public AddressBookDto() {}

    public AddressBookDto(String credentials, String email, String blogReference) {
        this.credentials = credentials;
        this.email = email;
        this.blogReference = blogReference;
    }

    public String getCredentials() {
        return credentials;
    }

    public void setCredentials(String credentials) {
        this.credentials = credentials;
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
}
