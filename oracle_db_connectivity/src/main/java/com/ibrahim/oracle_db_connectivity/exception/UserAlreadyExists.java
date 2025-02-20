package com.ibrahim.oracle_db_connectivity.exception;

public class UserAlreadyExists extends CustomException{

    public UserAlreadyExists() {
        super("User already exists" , "USER_409_NOT_FOUND");
    }


}
