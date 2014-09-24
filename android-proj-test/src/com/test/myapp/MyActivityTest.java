package com.test.myapp;

import android.annotation.TargetApi;
import android.os.Build;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.TextView;
import com.robotium.solo.Solo;
import junit.framework.Assert;

/**
 * This is a simple framework for a test of an Application.  See
 * {@link android.test.ApplicationTestCase ApplicationTestCase} for more information on
 * how to write and extend Application tests.
 * <p/>
 * To run this test, you can type:
 * adb shell am instrument -w \
 * -e class com.test.myapp.MyActivityTest \
 * com.test.myapp.tests/android.test.InstrumentationTestRunner
 */
@TargetApi(Build.VERSION_CODES.FROYO)
public class MyActivityTest extends ActivityInstrumentationTestCase2 {

    public MyActivityTest() {
        super(MyActivity.class);
    }
    private Solo solo;

    public void setUp() throws Exception {
        solo = new Solo(getInstrumentation(), getActivity());
    }

    public void testPreferenceIsSaved() throws Exception {
        TextView hello = (TextView) solo.getView("hello");
        Assert.assertEquals(hello.getText(), "Hello World, MyActivity");
    }

    @Override
    public void tearDown() throws Exception {
        solo.finishOpenedActivities();
    }
}
