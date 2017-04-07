package com.kaitait.droidtemplate.app;

import android.app.Application;

import com.kaitait.droidtemplate.app.components.AppComponent;
import com.kaitait.droidtemplate.app.components.ClockComponent;
import com.kaitait.droidtemplate.app.components.DaggerAppComponent;
import com.kaitait.droidtemplate.app.components.DaggerClockComponent;
import com.kaitait.droidtemplate.app.modules.AppModule;


public class ConductorApplication extends Application {
    static AppComponent app_component;
    static ClockComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        app_component = DaggerAppComponent.builder().appModule(new AppModule(this)).build();
        component = createComponent();
    }



    protected ClockComponent createComponent() {
        return DaggerClockComponent.builder().build();
    }

    public static ClockComponent getClockComponent() {
        return component;
    }

    public ClockComponent component() {
        return component;
    }

    public static AppComponent GetAppComponent() {
        return app_component;
    }
}
