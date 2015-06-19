package com.xioq.kestral.model;

/**
 * Created by bronwen.cassidy on 19/06/2015
 */
public enum UserType {

    CLIENT("C"), PROVIDER("P");

    private String type;

    UserType(String userType) {
        this.type = userType;
    }

    public String toString() {
        return type;
    }
}
