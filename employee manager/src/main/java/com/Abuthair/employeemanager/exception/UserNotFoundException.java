package com.Abuthair.employeemanager.exception;

/**
 * @author abuthair on 04/06/23.
 * 12:31 pm
 * @project employee manager
 */
public class UserNotFoundException extends  RuntimeException{
    public UserNotFoundException(String message) {
        super(message);
    }

    public UserNotFoundException(Throwable cause) {
        super(cause);
    }
}
