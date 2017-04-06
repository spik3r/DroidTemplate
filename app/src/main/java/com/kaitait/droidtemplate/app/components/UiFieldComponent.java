package com.kaitait.droidtemplate.app.components;


import com.kaitait.droidtemplate.app.modules.ReactiveFunctionModule;
import com.kaitait.droidtemplate.app.modules.ValidationModule;

import dagger.Component;

@ActivityScope
@Component(dependencies = {AppComponent.class},
        modules = {ReactiveFunctionModule.class, ValidationModule.class})
public interface UiFieldComponent
{
//    void Inject(ValidatingField validating_field);
//    void Inject(ReadableErrorFunction readable_error_function);
}
