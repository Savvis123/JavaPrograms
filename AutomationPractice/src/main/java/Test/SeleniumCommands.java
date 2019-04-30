package Test;

import java.awt.Toolkit;
import java.io.File;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sun.org.apache.bcel.internal.ExceptionConstants;

import KrishnaSakinalaSeleniumTestNG.TakeScreenShotOfEntirePage;

public class SeleniumCommands {

	private static final int nanos = 20;
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\ab64129\\Desktop\\driverfiles\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.wait(20);
		driver.wait(20, nanos);
		driver.switchTo().alert().accept();
		driver.switchTo().alert().dismiss();
		driver.switchTo().alert().sendKeys("mahesh");
		driver.switchTo().alert().getText();
		driver.switchTo().alert().getClass();
		
		driver.get("url");
		driver.getTitle();
		driver.getCurrentUrl();
		driver.getPageSource();
		driver.getWindowHandle();
		driver.getWindowHandles();
		driver.findElement(by);
		driver.findElements(by);
		driver.close();
		driver.quit();
		
		//dropdown 
		Select select=new Select(driver.findElement(By.id("mahesh")));
		select.selectByVisibleText("suresh");
		select.selectByValue("mahesh");
		select.selectByIndex(2);
		select.deselectAll();
		select.getAllSelectedOptions();
		select.getFirstSelectedOption();
		select.getOptions();
		select.isMultiple();
		
		
		
		//waits
		//implicit wait
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		//explicit wait
		WebDriverWait wait=new WebDriverWait(driver,60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("mahesh")));
		
		//Fluent wait
		Wait<WebDriver> wait1=new FluentWait<WebDriver>(driver)
				.withTimeout(30,TimeUnit.SECONDS)
				.pollingEvery(5, TimeUnit.SECONDS)
				.ignoring(NoSuchElementException.class);
		
		
		//frames
		
		driver.switchTo().frame(index);
		driver.switchTo().frame(nameOrId);
		driver.switchTo().frame(frameElement);
		driver.switchTo().defaultContent();
		driver.switchTo().parentFrame();
		
		//windows
		driver.switchTo().window(nameOrHandle);
		driver.getWindowHandle();
		Set<String> handle = driver.getWindowHandles();
		
		//actions
		WebElement mainelement=driver.findElement(By.id("Mahesh"));
		WebElement subelement=driver.findElement(By.id("Mahesh"));
		WebElement ele=driver.findElement(By.id("Mahesh"));
		
		//mouseover
		Actions action =new Actions(driver);
		action.moveToElement(mainelement).moveToElement(subelement).click().build().perform();
	
		//DragAndDrop
		
		action.dragAndDrop(mainelement, subelement).build().perform();
		
		//
		action.sendKeys(Keys.ENTER);
		action.sendKeys(Keys.PAGE_DOWN);
		action.sendKeys(Keys.F5);
		
		//right click using actions
		action.contextClick(mainelement).build().perform();
		
		//double click
		action.doubleClick(mainelement).build().perform();
		
		//Navigations
		driver.navigate().forward();
		driver.navigate().back();
		driver.navigate().refresh();
		driver.navigate().to("url");
		
		//open new tab and switch to new tab
		
		driver.findElement(By.id("mahesh")).sendKeys(Keys.CONTROL+"t");
		ArrayList<String> tabs=new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(0));
		
		String currentTab=driver.getWindowHandle();
		for(String tab:driver.getWindowHandles())
		{
			if(!tab.equals(currentTab))
          {
             driver.switchTo().window(tab);
           }
		}
		
		//switch to tab from  left to right using action class
		action.keyDown(Keys.CONTROL).sendKeys(Keys.TAB).build().perform();
		
		//switch to tab from right to left
		action.keyDown(Keys.CONTROL).keyDown(Keys.SHIFT).sendKeys(Keys.TAB).build().perform();
		
		
		
		//take screenshot
		
	File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(src, new File("C:/selenium/screenshot.png"));
	
	
	
	Toolkit tool=Toolkit.getDefaultToolkit();
	int width=(int)tool.getScreenSize().getWidth();
	int height=(int)tool.getScreenSize().getHeight();
	driver.manage().window().setSize(new Dimension(width,height));
	
	ChromeOptions co=new ChromeOptions();
	co.addArguments("--start-maximized");
		
		
		
		
		
		
		
		
		
		
		

	}

}
