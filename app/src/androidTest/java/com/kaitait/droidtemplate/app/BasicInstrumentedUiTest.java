package com.kaitait.droidtemplate.app;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.filters.SmallTest;
import android.support.test.runner.AndroidJUnit4;

import com.kaitait.droidtemplate.R;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(AndroidJUnit4.class)
@SmallTest
public class BasicInstrumentedUiTest
{
    @Test
    public void loadStringResource() throws Exception {
        Context appContext = InstrumentationRegistry.getTargetContext();
        String appName = appContext.getResources().getString(R.string.app_name);
        assertThat(appName, is("Droid Template"));
    }
}