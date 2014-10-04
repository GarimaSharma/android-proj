package utils;

import android.app.Activity;
import android.util.Log;

import java.io.*;

public class Logs {
    String tag;

    public Logs(Activity activity) {

         tag = " package name : " + activity.getPackageName() + " build-number is " +getBuildNumber();

    }

    private String getBuildNumber() {
        String ret = null;
        File fl = new File("/data/latestbuildnumber.txt");
        FileInputStream fin = null;
        try {
            fin = new FileInputStream(fl);
            ret = convertStreamToString(fin);
            fin.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ret;
    }

    public void log(String message){
        Log.i(tag, message);
    }

    public String convertStreamToString(InputStream is) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();
        String line = reader.readLine();
        reader.close();
        return sb.toString();
    }
}
