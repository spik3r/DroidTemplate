package com.kaitait.droidtemplate.app.components;

import android.content.Context;

import com.kaitait.droidtemplate.app.modules.AppModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component (modules = {AppModule.class})
public interface AppComponent
{
    Context ProvidesAppContext();
    
    //void Inject(ValidationErrorParser validation_error_parser);
}
