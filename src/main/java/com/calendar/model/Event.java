package com.calendar.model;

import java.math.BigDecimal;

/**
 * Created by yuson on 2016/2/19.
 * Event Model POJO Class
 */
public class Event
{
    private User eventUsr;
    private int eventID;
    private String eventTitle;
    private String eventInfo;
    private String eventClass;
    private BigDecimal eventStart;
    private BigDecimal eventEnd;

    public Event(User eventUsr, int eventID, String eventTitle, String eventInfo, String eventClass, BigDecimal eventStart, BigDecimal eventEnd)
    {
        this.eventUsr = eventUsr;
        this.eventID = eventID;
        this.eventTitle = eventTitle;
        this.eventInfo = eventInfo;
        this.eventClass = eventClass;
        this.eventStart = eventStart;
        this.eventEnd = eventEnd;
    }

    public User getEventUsr()
    {
        return eventUsr;
    }

    public void setEventUsr(User eventUsr)
    {
        this.eventUsr = eventUsr;
    }

    public int getEventID()
    {
        return eventID;
    }

    public void setEventID(int eventID)
    {
        this.eventID = eventID;
    }

    public String getEventTitle()
    {
        return eventTitle;
    }

    public void setEventTitle(String eventTitle)
    {
        this.eventTitle = eventTitle;
    }

    public String getEventInfo()
    {
        return eventInfo;
    }

    public void setEventInfo(String eventInfo)
    {
        this.eventInfo = eventInfo;
    }

    public String getEventClass()
    {
        return eventClass;
    }

    public void setEventClass(String eventClass)
    {
        this.eventClass = eventClass;
    }

    public BigDecimal getEventStart()
    {
        return eventStart;
    }

    public void setEventStart(BigDecimal eventStart)
    {
        this.eventStart = eventStart;
    }

    public BigDecimal getEventEnd()
    {
        return eventEnd;
    }

    public void setEventEnd(BigDecimal eventEnd)
    {
        this.eventEnd = eventEnd;
    }

}
