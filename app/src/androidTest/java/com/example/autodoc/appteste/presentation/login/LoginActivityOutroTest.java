package com.example.autodoc.appteste.presentation.login;


import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.runner.RunWith;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class LoginActivityOutroTest {

//    @Rule
//    public ActivityTestRule<LoginActivity> mActivityTestRule = new ActivityTestRule<>(LoginActivity.class);
//
//    @Test
//    public void loginActivityOutroTest() {
//        // Added a sleep statement to match the app's execution delay.
//        // The recommended way to handle such scenarios is to use Espresso idling resources:
//        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        ViewInteraction appCompatEditText = onView(
//                allOf(withId(R.id.edit_login),
//                        childAtPosition(
//                                childAtPosition(
//                                        withId(R.id.textInputLayout),
//                                        0),
//                                0),
//                        isDisplayed()));
//        appCompatEditText.perform(click());
//
//        ViewInteraction appCompatEditText2 = onView(
//                allOf(withId(R.id.edit_login),
//                        childAtPosition(
//                                childAtPosition(
//                                        withId(R.id.textInputLayout),
//                                        0),
//                                0),
//                        isDisplayed()));
//        appCompatEditText2.perform(replaceText("silasadailton@hotmail.com"), closeSoftKeyboard());
//
//        ViewInteraction appCompatEditText3 = onView(
//                allOf(withId(R.id.edit_senha),
//                        childAtPosition(
//                                childAtPosition(
//                                        withId(R.id.textInputLayout2),
//                                        0),
//                                0),
//                        isDisplayed()));
//        appCompatEditText3.perform(replaceText("123456"), closeSoftKeyboard());
//
//        ViewInteraction appCompatButton = onView(
//                allOf(withId(R.id.button_login), withText("Acessar"),
//                        childAtPosition(
//                                childAtPosition(
//                                        withId(android.R.id.content),
//                                        0),
//                                2),
//                        isDisplayed()));
//        appCompatButton.perform(click());
//
//        // Added a sleep statement to match the app's execution delay.
//        // The recommended way to handle such scenarios is to use Espresso idling resources:
//        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        pressBack();
//
//        ViewInteraction recyclerView = onView(
//                allOf(withId(R.id.recyclerViewMessage),
//                        childAtPosition(
//                                childAtPosition(
//                                        withId(android.R.id.content),
//                                        0),
//                                3),
//                        isDisplayed()));
//        recyclerView.perform(actionOnItemAtPosition(0, click()));
//
//        ViewInteraction recyclerView2 = onView(
//                allOf(withId(R.id.recyclerViewMessage),
//                        childAtPosition(
//                                childAtPosition(
//                                        withId(android.R.id.content),
//                                        0),
//                                3),
//                        isDisplayed()));
//        recyclerView2.perform(actionOnItemAtPosition(10, click()));
//
//    }
//
//    private static Matcher<View> childAtPosition(
//            final Matcher<View> parentMatcher, final int position) {
//
//        return new TypeSafeMatcher<View>() {
//            @Override
//            public void describeTo(Description description) {
//                description.appendText("Child at position " + position + " in parent ");
//                parentMatcher.describeTo(description);
//            }
//
//            @Override
//            public boolean matchesSafely(View view) {
//                ViewParent parent = view.getParent();
//                return parent instanceof ViewGroup && parentMatcher.matches(parent)
//                        && view.equals(((ViewGroup) parent).getChildAt(position));
//            }
//        };
//    }
}
