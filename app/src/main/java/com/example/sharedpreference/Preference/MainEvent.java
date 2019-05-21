package com.example.sharedpreference.Preference;

public class MainEvent {

    private Event event;

    public void setEventListener(Event event)
    {
        this.event = event;
    }

    public Event getEvent()
    {
        return event;
    }

    public void doEvent(Boolean aBoolean)
    {
        if (event != null)
        {

            event.nofifyMe(aBoolean);
        }
    }

}
