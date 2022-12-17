package com.example.phoenixhomes;


import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.Espresso.closeSoftKeyboard;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import android.support.test.espresso.Espresso;


import androidx.test.ext.junit.rules.ActivityScenarioRule;

import com.example.phoenixhomes.classes.user_registration;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;


public class user_registrationTest {


    @Rule
    public ActivityScenarioRule<user_registration> activityScenarioRule = new ActivityScenarioRule<user_registration>(user_registration.class);

    private String uName = "Mother Child Handbook";

    @Before
    public void setUp() throws Exception {

    }
    @Test
    public void testUserInputScenario(){
        //input some text in the edit test

        Espresso.onView(withId(R.id.banner)).perform(typeText(uName));
        //close soft keyboard
        closeSoftKeyboard();
        //perform button click
        Espresso.onView(withId(R.id.register)).perform(click());
        //check the text in textview
        Espresso.onView(withId(R.id.bannerDescription)).check(matches(withText("for better healthcare")));

    }

    @After
    public void tearDown() throws Exception {
    }
}