package com.calendar.model;

import java.sql.Connection;
import java.sql.Statement;
import java.util.Date;

import java.sql.*;

/**
 * Created by yuson on 2016/2/19.
 * User Info Model Class
 */
public class User
{
    private int usrID;
    private String usrPassword;
    private String usrNickname;
    private String usrEmail;
    private Date usrRegistered;

    private DbControl dbControl;

    public User()
    {
        dbControl = new DbControl("jdbc:mysql://ap-cdbr-azure-east-c.cloudapp.net:3306/acsm_1a07d58c9837ade", "b4601f33dc2d7f", "59f735c8");
    }

    public User(int usrID, String usrPassword, String usrNickname, String usrEmail, Date usrRegistered)
    {
        this.usrID = usrID;
        this.usrPassword = usrPassword;
        this.usrNickname = usrNickname;
        this.usrEmail = usrEmail;
        this.usrRegistered = usrRegistered;
    }

    //User Login
    public void login(String usrEmail, String usrPassword) throws UserLoginException
    {
        Connection connection = dbControl.connectToDatabase();
        try
        {
//            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM cal_user WHERE usr_email = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, usrEmail);

            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.last();
            if (resultSet.getRow() == 0)
            {
                throw new UserLoginException("No Such User");
            }
            //resultSet.next();
            resultSet.first();
            if (usrPassword.equals(resultSet.getString("usr_pass")))
            {
                this.usrID = resultSet.getInt("usr_id");
                this.usrPassword = resultSet.getString("usr_pass");
                this.usrNickname = resultSet.getString("usr_nickname");
                this.usrEmail = usrEmail;
                this.usrRegistered = resultSet.getDate("usr_registered");

                resultSet.close();
                preparedStatement.close();
                connection.close();
            }
            else
            {
                resultSet.close();
                preparedStatement.close();
                connection.close();
                throw new UserLoginException("Wrong Password");
            }

        }
        catch (SQLException e)
        {
            Logger.log(" Query Failed." + e.getMessage());
            e.printStackTrace();
            throw new UserLoginException("Database Error");
        }
    }

    public int getUsrID()
    {
        return usrID;
    }

    public String getUsrPassword()
    {
        return usrPassword;
    }

    public void setUsrPassword(String usrPassword)
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
