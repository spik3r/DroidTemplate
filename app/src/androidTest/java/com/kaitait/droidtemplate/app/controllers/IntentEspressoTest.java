package com.kaitait.droidtemplate.app.controllers;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.Intent;
import android.support.test.espresso.intent.rule.IntentsTestRule;

import com.bluelinelabs.conductor.Router;
import com.bluelinelabs.conductor.RouterTransaction;
import com.kaitait.droidtemplate.R;
import com.kaitait.droidtemplate.app.MainActivity;
import com.kaitait.droidtemplate.app.OtherActivity;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.intent.Intents.intending;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by kai-tait on 18/04/2017.
 */

public class IntentEspressoTest
{
    Router router;
    HomeController controller;
    
    @Rule
    public IntentsTestRule<MainActivity> testRule = new IntentsTestRule<>(MainActivity.class);
    
    @Before
    public void setUp() throws ExecutionException, InterruptedException
    {
        controller = new HomeController();
        
        FutureTask<Void> setRoot = new FutureTask<>(
                () ->
                {
                    router = testRule.getActivity().getRouter();
                    router.setRoot(RouterTransaction.with(controller));
                    return null;
                }
        );
    
        Activity activity = testRule.getActivity();
        activity.runOnUiThread(setRoot);
    
        setRoot.get();
    }
    
    //Test some test is displayed on the screen
    @Test
    public void titleIsDisplayed() {
        onView(withText("Home Controller")).check(matches(isDisplayed()));
    }
    
    //Test going to other activity but don't go there
    @Test
    public void testGoToActivity() throws Exception
    {
        Instrumentation.ActivityResult result =
                new Instrumentation.ActivityResult(Activity.RESULT_OK, new Intent());
        
        intending(hasComponent(OtherActivity.class.getName())).respondWith(result);
        onView(withId(R.id.intent_button)).perform(click());
    }
}
