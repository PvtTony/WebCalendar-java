package com.calendar.model;


import java.util.Date;

/**
 * Created by yst on 2016/3/3.
 * Class used to log info
 */
public class Logger
{
    public static void log(String message)
    {
        System.out.println("[" + new Date().toString() + "]" + " " + message);
    }
}
