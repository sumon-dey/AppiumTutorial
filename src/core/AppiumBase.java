package core;

import java.io.File;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class AppiumBase {

	public static AndroidDriver<AndroidElement> initializeAppiumCapabilities() {
		AndroidDriver<AndroidElement> androidDriver = null;
		try {
			// Set the desired capabilities
			File androidApkfile = new File("./app/ApiDemos-debug.apk");
			DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
			desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Nexus_5X_Edited_API_28");
			desiredCapabilities.setCapability(MobileCapabilityType.APP, androidApkfile.getAbsolutePath());
			desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");

			// Declare the Appium Server url and create AndroidElement object
			URL appiumServerUrl = new URL("http://127.0.0.1:4723/wd/hub");
			androidDriver = new AndroidDriver<AndroidElement>(appiumServerUrl, desiredCapabilities);
			androidDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return androidDriver;
	}
}
