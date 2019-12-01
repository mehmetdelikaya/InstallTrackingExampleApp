# InstallTrackingExampleApp
An example of Android app to demonstrate how to get referrer values from Google Play Store downloads

Clone the repository and make a build on your target device.
Using adb you can get some utm data by following adb shell commands

adb shell
am broadcast -a com.android.vending.INSTALL_REFERRER -n installtracking.com.installtrackingexampleapp/.CampaignReceiver --es "referrer" "utm_source=test_source&utm_medium=test_medium&utm_term=test_term&utm_content=test_content&utm_campaign=test_name"

After executing these commands on adb, run the app and you will see the utm data displayed on the MainActivity and also in the logcat
