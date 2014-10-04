package com.test.myapp;

import android.app.Activity;
import android.os.Bundle;
import utils.Logs;

public class MyActivity extends Activity  {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        Logs logDriver = new Logs(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        logDriver.log("my first log");
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        logDriver.log("my first log");
    }
}
