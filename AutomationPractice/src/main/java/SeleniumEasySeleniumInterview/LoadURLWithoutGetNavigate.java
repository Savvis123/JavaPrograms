package SeleniumEasySeleniumInterview;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoadURLWithoutGetNavigate {
	
public static void main(String[] args) {

System.out.println("Execution Starts");
// Setting chrome driver property and opening chrome browser
System.setProperty("webdriver.chrome.driver",
		"C:\\Users\\ab64129\\Desktop\\NaveenAutomationLabsRestAPI\\AutomationPractice\\src\\test\\resources\\chromedriver.exe");

WebDriver driver= new ChromeDriver();
System.out.println("Browser opened.");
// We need to downcast WebDriver reference varaible to use JavascriptExecutor methods
JavascriptExecutor js= (JavascriptExecutor) driver;
String url = "https://www.google.com";
String script = "window.location = \'"+url+"\'";
js.executeScript(script);
System.out.println(driver.getCurrentUrl());
driver.quit();
}
}