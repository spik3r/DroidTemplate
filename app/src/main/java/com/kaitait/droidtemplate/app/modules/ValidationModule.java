package com.kaitait.droidtemplate.app.modules;

import android.content.Context;
import com.kaitait.droidtemplate.app.components.ActivityScope;

import net.sf.oval.Validator;

import dagger.Module;
import dagger.Provides;

@Module
public class ValidationModule
{
    private final Context app_context;
    
    public ValidationModule(Context app_context)
    {
        this.app_context = app_context;
    }
    
    @Provides
    @ActivityScope
    Validator ProvidesValidator()
    {
        return new Validator();
    }
    
//    @Provides
//    @ActivityScope
//    ValidationErrorParser ProvidesValidationErrorParser()
//    {
//        return new ValidationErrorParser(app_context);
//    }
}
