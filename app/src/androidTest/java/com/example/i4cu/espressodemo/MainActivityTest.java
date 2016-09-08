package com.example.i4cu.espressodemo;

import android.support.test.espresso.IdlingResource;
import android.support.test.espresso.Espresso;
import android.support.test.espresso.UiController;
import android.support.test.espresso.ViewAction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import static android.support.test.espresso.Espresso.pressBack;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.openActionBarOverflowOrOptionsMenu;
import static android.support.test.espresso.Espresso.openContextualActionModeOverflowMenu;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.longClick;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.action.ViewActions.swipeUp;
import static android.support.test.espresso.action.ViewActions.swipeDown;
import static android.support.test.espresso.action.ViewActions.swipeLeft;
import static android.support.test.espresso.action.ViewActions.swipeRight;
import static android.support.test.espresso.action.ViewActions.scrollTo;
import static android.support.test.espresso.matcher.ViewMatchers.isAssignableFrom;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withParent;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static android.support.test.InstrumentationRegistry.*;

import android.support.test.espresso.matcher.BoundedMatcher;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.runner.RunWith;
import org.junit.Rule;
import org.junit.Test;

import android.view.View;
import android.view.ViewGroup;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class MainActivityTest {

    @Rule
    public ActivityTestRule activityRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void testGenerated() {

        // Click at FloatingActionButton with id R.id.fab
        onView(withId(R.id.fab)).perform(click());

        // Set text to '45' in AppCompatEditText with id R.id.edtAge
        onView(withId(R.id.edtAge)).perform(replaceText("45"));

        // Set text to 'wnlns' in AppCompatEditText with id R.id.edtName
        onView(withId(R.id.edtName)).perform(replaceText("wnlns"));

        // Click at AppCompatButton with id R.id.btnSubmit
        onView(withId(R.id.btnSubmit)).perform(click());
    }
}