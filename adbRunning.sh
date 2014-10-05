emulatorName=$1
presence=$(adb devices | grep $emulatorName)

case "$presence" in
  *device*) echo "present and running"
    exit 0;;
  *offline*) echo "prensent but offline"
    exit 1;;
  *)         echo "not connected"
    exit 1;;
esac