package com.example.i4cu.espressodemo;

import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.rule.ActivityTestRule;
import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.doesNotExist;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.RootMatchers.withDecorView;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withHint;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.core.IsNot.not;

/**
 * Created by Quan Bui on 07/09/2016.
 */
public class NewUserDialogTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule =
        new ActivityTestRule<>(MainActivity.class);

    @Test
    public void testEnterUserWork() {

        onView(withId(R.id.fab)).perform(click());

        onView(withId(R.id.dialog)).check(matches(isDisplayed()));

        onView(withHint("Enter name")).perform(typeText("Quan"), closeSoftKeyboard());

        onView(withId(R.id.edtName)).check(matches(withText("Quan")));

        onView(withId(R.id.edtAge)).perform(typeText("25"), closeSoftKeyboard())
            .check(matches(withText("25")));

        onView(withId(R.id.btnSubmit)).perform(click());

        onView(withId(R.id.tvName)).check(matches(isDisplayed()));

        onView(withId(R.id.rvList)).perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));

        onView(withId(R.id.dialogUserDetails)).check(matches(isDisplayed()));

        onView(withId(R.id.imvClose)).perform(click());

        onView(withId(R.id.dialogUserDetails)).check(doesNotExist());

        onView(withId(R.id.fab)).perform(click());

        onView(withText("Add")).perform(click());

        onView(withText("Error!")).inRoot(withDecorView(not(mActivityRule.getActivity()
                                                                .getWindow()
                                                                .getDecorView())))
            .check(matches(isDisplayed()));
    }
}
