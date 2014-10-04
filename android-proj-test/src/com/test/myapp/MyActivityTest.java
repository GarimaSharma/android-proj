package com.test.myapp;

import android.annotation.TargetApi;
import android.os.Build;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.TextView;
import com.robotium.solo.Solo;
import junit.framework.Assert;

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

    public void testPreferenceIsSavedWithNew() throws Exception {
        TextView hello = (TextView) solo.getView("newText");
        Assert.assertEquals(hello.getText(), "new test text");
    }

    @Override
    public void tearDown() throws Exception {
        solo.finishOpenedActivities();
    }
}
