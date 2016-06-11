package com.calendar.service;

import com.calendar.model.Event;
import com.calendar.model.User;

/**
 * Created by yst on 2016/3/3.
 * Event Manager Module
 */
public class EventManager
{
    /*private ArrayList<Event> events = new ArrayList<>();
    private DbControl dbControl = new DbControl("jdbc:mysql://localhost:3306/calendar", "calendar", "89023331");
    private User user;*/

    public EventManager(User user)
    {
        /*this.user = user;
        this.getAllEvents();*/
    }

    public void addEvent(Event event)
    {
       /* Connection connection = dbControl.connectToDatabase();

        try
        {
            int usrID = event.getEventUsr().getUsrID();
            int eventID = event.getEventID();
            String calTitle = event.getEventTitle();
            String calClass = event.getEventClass();
            String calInfo = event.getEventInfo();
            BigDecimal calStart = event.getEventStart();
            BigDecimal calEnd = event.getEventEnd();
            String sql = "INSERT INTO cal_data VALUES(?,?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, usrID);
            preparedStatement.setString(2, calTitle);
            preparedStatement.setString(3, calClass);
            preparedStatement.setString(4, calInfo);
            preparedStatement.setBigDecimal(5, calStart);
            preparedStatement.setBigDecimal(6, calEnd);

            preparedStatement.executeQuery();
            *//*
            * Should I set some verification process?
            *
            * *//*
            this.refreshAllEvents();
        }
        catch (SQLException e)
        {
            Logger.log(e.getMessage());
            e.printStackTrace();
        }*/
    }

//    public void delEvent(int )

   /* private void refreshAllEvents()
    {
        this.cleanAllEvents();
        this.getAllEvents();
    }
    private void cleanAllEvents()
    {
        if (!this.events.isEmpty())
        {
            for (int index = 0; index < events.size(); index++)
            {
                events.remove(index);
            }
        }

    }

    private void getAllEvents()
    {
        this.cleanAllEvents();
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

            resultSet.close();
            preparedStatement.close();
            connection.close();
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
    }*/
}
