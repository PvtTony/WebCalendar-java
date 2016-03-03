package com.calendar.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.json.simple.*;

/**
 * Created by yst on 2016/3/3.
 */
public class EventManager
{
    private ArrayList<Event> events = new ArrayList<>();
    private DbControl dbControl = new DbControl("jdbc:mysql://ap-cdbr-azure-east-c.cloudapp.net:3306/acsm_1a07d58c9837ade", "b4601f33dc2d7f", "59f735c8");
    private User user;

    public EventManager(User user)
    {
        this.user = user;
        this.getAllEvents();
    }


    public void getAllEvents()
    {
        if (!this.events.isEmpty())
        {
            for (int index = 0; index < events.size(); index++)
            {
                events.remove(index);
            }
        }

        Connection connection = dbControl.connectToDatabase();

        try
        {
            String sql = "SELECT * FROM cal_data WHERE usr_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, user.getUsrID());

            ResultSet resultSet = preparedStatement.executeQuery();


            while (resultSet.next())
            {
                int calID = resultSet.getInt("cal_id");
                String calTitle = resultSet.getString("cal_title");
                String calClass = resultSet.getString("cal_class");
//                BigDecimal calStart = resultSet.getInt("cal_start");
                BigDecimal calStart = resultSet.getBigDecimal("cal_start");
                BigDecimal calEnd = resultSet.getBigDecimal("cal_end");
//                BigDecimal calEnd = resultSet.getInt("cal_end");
                String calInfo = resultSet.getString("cal_info");
                this.events.add(new Event(user, calID, calTitle, calInfo, calClass, calStart, calEnd));
            }


        }
        catch (SQLException e)
        {
            Logger.log(e.getMessage());
            e.printStackTrace();
        }
    }

    public String getEventsInJson()
    {

        JSONArray jsonArray = new JSONArray();
        for (int index = 0; index < events.size(); index++)
        {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("id", events.get(index).getEventID());
            jsonObject.put("title", events.get(index).getEventTitle());
            jsonObject.put("url", "");
            jsonObject.put("class", events.get(index).getEventClass());
            jsonObject.put("start", events.get(index).getEventStart());
            jsonObject.put("end", events.get(index).getEventEnd());

            jsonArray.add(jsonObject);
        }
        return jsonArray.toJSONString();
    }

    public ArrayList<Event> getEvents()
    {
        return events;
    }

    public User getUser()
    {
        return user;
    }
}
