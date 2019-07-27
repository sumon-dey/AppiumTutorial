package core;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class AppiumBasicTest extends AppiumBase {

	public static void main(String[] args) {
		AndroidDriver<AndroidElement> androidDriver = initializeAppiumCapabilities();
		AndroidElement preferenceText = androidDriver.findElementByXPath("//*[@text='Preference']");
		preferenceText.click();
		AndroidElement preferenceDependenciesText = androidDriver
				.findElementByXPath("//android.widget.TextView[@text='3. Preference dependencies']");
		preferenceDependenciesText.click();
		AndroidElement wifiCheckbox = androidDriver.findElementById("android:id/checkbox");
		wifiCheckbox.click();
	}

}
