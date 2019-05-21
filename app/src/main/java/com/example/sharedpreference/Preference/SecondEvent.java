package com.example.sharedpreference.Preference;

public class SecondEvent extends Preference implements Event {

    @Override
    public void nofifyMe(Boolean aBoolean) {

        debug("SecondEvent",  "" + aBoolean);

    }
}
