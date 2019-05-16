package com.example.sharedpreference;

public class SecondEvent extends Preference implements Event {

    @Override
    public void nofifyMe(Boolean aBoolean) {

        debug("SecondEvent",  "" + aBoolean);

    }
}
