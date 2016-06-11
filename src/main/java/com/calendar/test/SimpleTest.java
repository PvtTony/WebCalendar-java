package com.calendar.test;

import com.calendar.service.UserLoginException;
import com.calendar.service.UserServiceManager;

/**
 * Created by yuson on 2016/6/11.
 */
public class SimpleTest
{
    public static void main(String[] args)
    {
        try
        {
            UserServiceManager.getUserServiceManager()
                    .login("469224206@qq.com", "89023331");
        }
        catch (UserLoginException e)
        {
            e.printStackTrace();
        }
    }

}
