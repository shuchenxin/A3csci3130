package com.acme.a3csci3130;

import android.support.annotation.NonNull;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.hasContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class SimpleEspressoTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(
            MainActivity.class);


    @Test
    public void button1(){

        onView(withId(R.id.submitButton)).perform(click());
        onView(withId(R.id.number)).perform(typeText("938475628"));
        onView(withId(R.id.name)).perform(typeText("ksjd"));
        onView(withId(R.id.primary)).perform(typeText("Fisher"));
        onView(withId(R.id.address)).perform(typeText("sldk"));
        onView(withId(R.id.province)).perform(typeText("NS"));
        onView(withId(R.id.submitButton)).perform(click());
        onData(org.hamcrest.Matchers.anything()).inAdapterView(withId(R.id.listView)).atPosition(0).perform(click());
        onView(withId(R.id.number)).check(matches(withText("938475628")));
        onView(withId(R.id.name)).check(matches(withText("ksjd")));
        onView(withId(R.id.primary)).check(matches(withText("Fisher")));
        onView(withId(R.id.address)).check(matches(withText("sldk")));
        onView(withId(R.id.province)).check(matches(withText("NS")));
        onView(withId(R.id.primary)).perform(replaceText("Distributor"));
        onView(withId(R.id.updateButton)).perform(click());
        onData(org.hamcrest.Matchers.anything()).inAdapterView(withId(R.id.listView)).atPosition(0).perform(click());
        onView(withId(R.id.primary)).check(matches(withText("Distributor")));
    }

    @Test
    public void button2(){
        onView(withId(R.id.submitButton)).perform(click());
        onView(withId(R.id.number)).perform(typeText("938475628"));
        onView(withId(R.id.name)).perform(typeText("ksjd"));
        onView(withId(R.id.primary)).perform(typeText("Fisher"));
        onView(withId(R.id.address)).perform(typeText("sldk"));
        onView(withId(R.id.province)).perform(typeText("NS"));
        onView(withId(R.id.submitButton)).perform(click());
        onData(org.hamcrest.Matchers.anything()).inAdapterView(withId(R.id.listView)).atPosition(0).perform(click());
        onView(withId(R.id.deleteButton)).perform(click());
        onData(org.hamcrest.Matchers.anything()).inAdapterView(withId(R.id.listView)).atPosition(0).equals(null);
    }

}
