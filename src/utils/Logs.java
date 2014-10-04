package utils;

import android.app.Activity;
import android.util.Log;

import java.io.*;

public class Logs {
    String tag;

    public Logs(Activity activity) {

         tag = " package name : " + activity.getPackageName() + " build-number is " + getBuildNumber() +" device name is : " + android.os.Build.MODEL;

    }

    private String getBuildNumber() {
        String ret = null;
        File fl = new File("/data/latestbuildnumber.txt");
        FileInputStream fin = null;
        try {
            fin = new FileInputStream(fl);
            BufferedReader reader = new BufferedReader(new InputStreamReader(fin));
            ret = reader.readLine().toString();
            reader.close();
            fin.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ret;
    }

    public void log(String message){
        Log.i(tag, message);
    }

}
