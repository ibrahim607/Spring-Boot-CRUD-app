package com.ibrahim.oracle_db_connectivity.exception;

public class UserNotFoundException extends CustomException {


    public UserNotFoundException() {
        super("User not found" , "USER_404_NOT_FOUND");
    }
}
