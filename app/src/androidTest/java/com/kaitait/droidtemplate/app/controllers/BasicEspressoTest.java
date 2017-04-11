package com.kaitait.droidtemplate.app.controllers;

import android.support.test.espresso.contrib.PickerActions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;
import android.widget.DatePicker;

import com.kaitait.droidtemplate.R;
import com.kaitait.droidtemplate.app.MainActivity;

import org.hamcrest.Matchers;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withClassName;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static com.kaitait.droidtemplate.R.id.datePicker2;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.core.Is.is;

@RunWith(AndroidJUnit4.class)
public class BasicEspressoTest
{
    @Rule
    public ActivityTestRule<MainActivity> testRule = new ActivityTestRule<>(MainActivity.class);
    
    @Test
    public void titleIsDisplayed() {
        onView(withText("Droid Template")).check(matches(isDisplayed()));
    }
    
    @Test
    public void controllerNameIsDisplayed() {
        onView(withText("Home Controller")).check(matches(isDisplayed()));
    }
    
    @Test
    public void buttonClickedAndOtherPageDisplayed() throws Exception
    {
        onView(withId(R.id.next_button))
                .perform(click());
    
        onView(withText("The other controller")).check(matches(isDisplayed()));
    }
    
    @Test
    public void spinnerOptionSelected() throws Exception
    {
        onView(withId(R.id.next_button))
                .perform(click());
        
        onView(withId(R.id.spinner))
                .perform(click());
        
        onData(allOf(is(instanceOf(String.class)), is("Mandarin"))).perform(click());
    }
    
    @Test
    public void datePickerOptionSelected() throws Exception
    {
        onView(withId(R.id.next_button))
                .perform(click());
        
        setDate(datePicker2, 2000, 5, 18);
        onView(withText("Thursday")).check(matches(isDisplayed()));
        onView(withText("18")).check(matches(isDisplayed()));
        onView(withText("MAY")).check(matches(isDisplayed()));
        onView(withText("2000")).check(matches(isDisplayed()));
        Log.i("Datepicker: " , onView(withId(R.id.datePicker2)).toString());
    }
    
    public static void setDate(int datePickerLaunchViewId, int year, int monthOfYear, int dayOfMonth) {
        onView(withId(datePicker2)).perform(click());
        onView(withClassName(Matchers.equalTo(DatePicker.class.getName()))).perform(PickerActions
                                                                                            .setDate(year, monthOfYear, dayOfMonth));
    }
}