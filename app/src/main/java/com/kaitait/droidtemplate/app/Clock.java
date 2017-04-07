package com.kaitait.droidtemplate.app;

/**
 * Created by kai-tait on 7/04/2017.
 */

import org.joda.time.DateTime;

import javax.inject.Singleton;

@Singleton
public class Clock {
    public DateTime getNow() {
        return new DateTime();
    }
}
