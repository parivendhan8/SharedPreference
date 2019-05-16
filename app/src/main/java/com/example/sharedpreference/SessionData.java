package com.example.sharedpreference;

public class SessionData {

    private static SessionData instance;


    public static SessionData getInstance()
    {
        if (instance == null)
        {
            instance = new SessionData();
        }

        return instance;
    }

    Event event;


    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }
}
