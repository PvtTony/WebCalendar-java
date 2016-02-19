package com.calendar.model;

import java.util.Date;

/**
 * Created by yuson on 2016/2/19.
 * User Info Model Class
 */
public class User
{

    private int usrID;
    private int usrPassword;
    private String usrNickname;
    private String usrEmail;
    private Date usrRegistered;

    public int getUsrID()
    {
        return usrID;
    }

    public void setUsrID(int usrID)
    {
        this.usrID = usrID;
    }

    public int getUsrPassword()
    {
        return usrPassword;
    }

    public void setUsrPassword(int usrPassword)
    {
        this.usrPassword = usrPassword;
    }

    public String getUsrNickname()
    {
        return usrNickname;
    }

    public void setUsrNickname(String usrNickname)
    {
        this.usrNickname = usrNickname;
    }

    public String getUsrEmail()
    {
        return usrEmail;
    }

    public void setUsrEmail(String usrEmail)
    {
        this.usrEmail = usrEmail;
    }

    public Date getUsrRegistered()
    {
        return usrRegistered;
    }

    public void setUsrRegistered(Date usrRegistered)
    {
        this.usrRegistered = usrRegistered;
    }
}
