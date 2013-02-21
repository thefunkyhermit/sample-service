package com.aidangordon.api.bean;

/**
 * Created with IntelliJ IDEA.
 * User: agordon
 * Date: 2013-02-20
 * Time: 11:48 PM
 * To change this template use File | Settings | File Templates.
 */
public class User {
    private final String firstName;

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    private final String lastName;

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
