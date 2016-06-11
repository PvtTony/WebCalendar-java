package com.calendar.service;

import com.calendar.model.User;
import com.calendar.util.Logger;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuson on 2016/6/11.
 */
public class UserServiceManager
{
    private static SessionFactory factory;

    private static UserServiceManager userServiceManager;
    public UserServiceManager()
    {
        try
        {
            factory = new Configuration().configure().buildSessionFactory();
        }catch (Throwable ex)
        {
            Logger.log("Failed to build session factory");
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static UserServiceManager getUserServiceManager()
    {
        if (userServiceManager != null)
        {
            return userServiceManager;
        }
        else
        {
            return new UserServiceManager();
        }
    }




    public Integer newUser(String usrPassword, String usrNickname, String usrEmail)
    {
        Session session = factory.openSession();
        Transaction transaction = null;
        Integer usrID = null;
        try
        {
            transaction = session.beginTransaction();
//            User user = new User(usrPassword, usrNickname, usrEmail);
            User user = new User(usrPassword, usrNickname, usrEmail);
            usrID = (Integer) session.save(user);
            transaction.commit();
        }
        catch (HibernateException e)
        {
            if(transaction != null)
            {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        finally
        {
            session.close();
        }
        return usrID;
    }
    @SuppressWarnings("unchecked")
    public void login(String usrEmail, String usrPassword) throws UserLoginException
    {
        Session session = factory.openSession();
        Transaction transaction = null;
        try
        {
            transaction = session.beginTransaction();
            List<User> userList = new ArrayList<>();
            userList = session.createQuery("FROM User user WHERE user.usrEmail = ? AND user.usrPassword = ?")
                    .setParameter(0, usrEmail)
                    .setParameter(1, usrPassword)
                    .list();
            if(userList.size() != 1)
            {
                throw new UserLoginException("Username or password is wrong");
            }
        }
        catch (HibernateException e)
        {
            if (transaction != null)
            {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        finally
        {
            session.close();
        }
    }

}
