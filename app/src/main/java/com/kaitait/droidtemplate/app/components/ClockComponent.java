package com.kaitait.droidtemplate.app.components;

/**
 * Created by kai-tait on 7/04/2017.
 */

import com.kaitait.droidtemplate.app.controllers.HomeController;
import com.kaitait.droidtemplate.app.modules.ClockModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = ClockModule.class)
public interface ClockComponent {
    void inject(HomeController controller);
}
