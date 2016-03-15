package com.calendar.model;

import org.jetbrains.annotations.Nullable;
import sun.rmi.runtime.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Date;

/**
 * Created by yst on 2016/3/3.
 * Database Managerment Class
 */
public class DbControl
{
    //database url
    private String url;
    //db usrname
    private String username;
    //db pw
    private String password;

    public DbControl(String url, String username, String password)
    {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public String getUrl()
    {
        return url;
    }

    public void setUrl(String url)
    {
        this.url = url;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    @Nullable
    public Connection connectToDatabase()
    {
        try
        {
            //find mysql connector
            Class.forName("com.mysql.jdbc.Driver");
            Logger.log("Found MySQL Driver.");

        }
        catch (ClassNotFoundException e)
        {
            Logger.log("MySQL Driver Not Found.");
            e.printStackTrace();
        }

        try
        {
            Logger.log("Database Connected.");
            return DriverManager.getConnection(this.url, this.username, this.password);
        }
        catch (SQLException e)
        {
            Logger.log("Database Connection Failed.");
            e.printStackTrace();
            return null;
        }
    }
}
