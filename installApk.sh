emulatorName=$1
./adbRunning.sh $emulatorName
if [ $? == 1 ]
  then exit 1
else
  if [ $2 == "app" ]
    then packageName="com.test.myapp"
    apkPrefix="android-proj-debug"
    packageLocation=packages
    appName=$(adb -s $emulatorName shell pm list packages \"com.test.myapp\" | sed '/tests/d')
  elif [ $2 == "test" ]
    then packageName="com.test.myapp.tests"
    apkPrefix="android-proj-test-debug"
    packageLocation=test-packages
    appName=$(adb -s $emulatorName shell pm list packages \"com.test.myapp.tests\")
  else
    echo "wrong use!!"
    echo "installApk.sh app //to install app apk"
    echo "installApk.sh test //to install test apk"
    exit 1
  fi


  echo "app name is ...$appName ..."
  if [[ -n $appName ]]
    then
    adb -s $emulatorName shell pm uninstall $packageName
    echo "uninstalled"
  fi
  echo "now installing"
  adb -s $emulatorName install $packageLocation/$apkPrefix-${GO_DEPENDENCY_LABEL_BUILD}.apk
fi