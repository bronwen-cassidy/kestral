package com.xioq.kestral.services.security;

import javax.security.auth.login.FailedLoginException;

/**
 * Created by bronwen.cassidy on 03/06/2015.
 */
public class InvalidLoginCredentialsException extends FailedLoginException {

    public InvalidLoginCredentialsException() {
    }

    public InvalidLoginCredentialsException(String message) {
        super(message);
    }
}
