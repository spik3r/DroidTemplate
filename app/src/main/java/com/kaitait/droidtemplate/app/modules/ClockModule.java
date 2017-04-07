package com.kaitait.droidtemplate.app.modules;

/**
 * Created by kai-tait on 7/04/2017.
 */

import com.kaitait.droidtemplate.app.Clock;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ClockModule {
    @Provides
    @Singleton
    Clock provideClock() {
        return new Clock();
    }
}
