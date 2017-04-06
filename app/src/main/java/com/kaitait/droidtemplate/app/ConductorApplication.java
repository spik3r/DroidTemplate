package com.kaitait.droidtemplate.app;

import android.app.Application;

import com.kaitait.droidtemplate.app.components.AppComponent;
import com.kaitait.droidtemplate.app.components.DaggerAppComponent;
import com.kaitait.droidtemplate.app.components.DaggerUiFieldComponent;
import com.kaitait.droidtemplate.app.components.UiFieldComponent;
import com.kaitait.droidtemplate.app.modules.AppModule;


public class ConductorApplication extends Application
{
    static AppComponent app_component;
    static UiFieldComponent ui_field_component;
     
    @Override
    public void onCreate()
    {
        super.onCreate();
        app_component = DaggerAppComponent.builder().appModule(new AppModule(this)).build();
        ui_field_component = DaggerUiFieldComponent
                .builder()
                .appComponent(app_component)
                .build();
    }
    
    public static AppComponent GetAppComponent()
    {
        return app_component;
    }
    
    public static UiFieldComponent GetUiFieldComponent()
    {
        return ui_field_component;
    }
}
