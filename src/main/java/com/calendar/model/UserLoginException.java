package com.calendar.model;

/**
 * Created by yst on 2016/3/3.
 * UserLoginException for failed login error
 */
public class UserLoginException extends Exception
{
    private String message;

    public UserLoginException()
    {
        super();
    }

    public UserLoginException(String message)
    {
        super(message);
    }
}
