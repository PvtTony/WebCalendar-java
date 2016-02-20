package com.calendar.model;

import com.mysql.jdbc.*;
import org.jetbrains.annotations.Nullable;

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

    private String url = "jdbc:mysql://ap-cdbr-azure-east-c.cloudapp.net:3306/acsm_1a07d58c9837ade";
    private String username = "b4601f33dc2d7f";
    private String password = "59f735c8";

    @Nullable
    private static Connection connectToDatabase(String url, String username, String password)
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println(new Date().toString() + " Found MySQL Driver.");
        }
        catch (ClassNotFoundException e)
        {
            System.out.println(new Date().toString() + " MySQL Driver Not Found.");
            e.printStackTrace();
        }

        try
        {
            System.out.println(new Date().toString() + " Database Connected.");
            return DriverManager.getConnection(url, username, password);
        }
        catch (SQLException e)
        {
            System.out.println(new Date().toString() + " Database Connection Failed.");
            e.printStackTrace();
            return null;
        }
    }

    public User()
    {

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
    public boolean login(String usrEmail, String usrPassword)
    {
        Connection connection = connectToDatabase(url, username, password);
        try
        {
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM cal_user WHERE usr_email = \'" + usrEmail + "\'";
            ResultSet resultSet = statement.executeQuery(sql);
            resultSet.next();
            if (usrPassword.equals(resultSet.getString("usr_pass")))
            {
                this.usrID = resultSet.getInt("usr_id");
                this.usrPassword = resultSet.getString("usr_pass");
                this.usrNickname = resultSet.getString("usr_nickname");
                this.usrEmail = usrEmail;
                this.usrRegistered = resultSet.getDate("usr_registered");

                resultSet.close();
                statement.close();
                connection.close();
                return true;
            }
            else
            {
                resultSet.close();
                statement.close();
                connection.close();
                return false;
            }

        }
        catch (SQLException e)
        {
            System.out.println(new Date().toString() + " Query Failed.");
            e.printStackTrace();
            return false;
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
