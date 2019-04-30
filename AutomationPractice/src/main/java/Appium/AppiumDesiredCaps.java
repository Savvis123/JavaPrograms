package Appium;

import java.io.File;

import org.openqa.selenium.remote.DesiredCapabilities;

public class AppiumDesiredCaps {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		File appDir = new File(“/Users/Steve/Development/SampleApps”);
		File app = new File(appDir, “Flipkart.apk”);
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(“device”,”Android”);
		//mandatory capabilities
		capabilities.setCapability(“deviceName”,”Android”);
		capabilities.setCapability(“platformName”,”Android”);
		capabilities.setCapability("udid", Properties.udid);

		//other caps
		capabilities.setCapability(“app”, app.getAbsolutePath());
		AppiumDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL(“http://127.0.0.1:4723/wd/hub”), capabilities);

	}

}
