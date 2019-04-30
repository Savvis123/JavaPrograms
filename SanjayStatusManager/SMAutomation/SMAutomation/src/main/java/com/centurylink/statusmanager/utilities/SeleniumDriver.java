package com.centurylink.statusmanager.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumDriver {

	// class reference
	@SuppressWarnings("unused")
	private static SeleniumDriver seleniumDriver;
	
	// init webDriver
	private static WebDriver driver;

	@SuppressWarnings("unused")
	private static WebDriverWait waitDriver;

	static FileInputStream readBaseFile;
	static Properties prop = new Properties();

	public static String EnvironmentSelected;

	// driver timeout
	public static final int TIMEOUT = 30;

	public static final int PAGE_LOAD_TIMEOUT = 30;

	public static void SeleniumDriverInitialization() {

		try {
			readBaseFile = new FileInputStream(URLConfigs.BASE_FILE_PATH);
			prop = new Properties();
			prop.load(readBaseFile);

		} catch (FileNotFoundException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();
		}
		;

		String getBrowserName = prop.getProperty("Browser");
		System.out.println(getBrowserName);

		if (getBrowserName.equalsIgnoreCase("CHROME")) {

			System.setProperty("webdriver.chrome.driver", URLConfigs.CHROMEDRIVER_PATH);
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		}
		waitDriver = new WebDriverWait(driver, TIMEOUT);
		driver.manage().timeouts().implicitlyWait(TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		System.out.println("driver = " + driver);
	}

	// to get the url - use this
	public static void launchApplication() throws IOException {

		selectExecutionEnvironment();
		driver.navigate().to(EnvironmentSelected);

	}

	// to get the driver isntance
	/**
	 * @returns the WebDriver Instance
	 */
	public static WebDriver getDriver() {

		return driver;
	}

	/**
	 * @return the Test Environment
	 */
	public static String selectExecutionEnvironment() {

		EnvironmentSelected = prop.getProperty("Test2_URL");
	//	System.out.println("Execution Environment = " + EnvironmentSelected);

		return EnvironmentSelected;
	}

	/**
	 * @returns the time in the custom format
	 */
	public static String timestamp() {

		String timstamp = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
		return timstamp;
	}

	public static void waitforPageToLoad() {

		driver.manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
	}

	public static void setupDriver() {

		SeleniumDriverInitialization();
	}

	public static void tearDown() {

		if (driver != null) {

			driver.quit();
		}
		seleniumDriver = null;
	}
}
