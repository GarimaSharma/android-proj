package utils;

import android.app.Activity;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.util.Log;

public class Logs {
    String tag;

    public Logs(Activity activity) {
        String apkName = getApkName(activity);
        apkName = apkName.replace("/data/app/com.test.myapp-", "");
        apkName = apkName.replace(".apk", "");
        tag = "package name : " + activity.getPackageName() + " build-number : " + apkName + " ";

    }

    private String getApkName(Activity activity) {
        String sourceApk = null;
        PackageManager pm = activity.getPackageManager();
        try {
            ApplicationInfo ai = pm.getApplicationInfo("com.test.myapp", 0);
            sourceApk = ai.publicSourceDir;
        } catch (PackageManager.NameNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return sourceApk;
    }

    public void log(String message){
        Log.i(tag, message);
    }
}
