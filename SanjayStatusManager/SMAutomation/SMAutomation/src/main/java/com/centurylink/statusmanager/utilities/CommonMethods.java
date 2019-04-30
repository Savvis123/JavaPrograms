package com.centurylink.statusmanager.utilities;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
//import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonMethods extends SeleniumDriver {

	/**
	 * @param welement
	 * @Description - wait for visibility of element in the page for seconds.
	 * 
	 */
	public static void WaitforElement(WebElement welement) {

		WebDriverWait wait = new WebDriverWait(getDriver(), 200);
		wait.until(ExpectedConditions.visibilityOf(welement));

	}

	/**
	 * @param suggestionSize
	 * 
	 */
	public static void WaitforElements(List<WebElement> suggestionSize) {

		WebDriverWait wait = new WebDriverWait(getDriver(), 200);
		wait.until(ExpectedConditions.visibilityOfAllElements(suggestionSize));

	}

	/**
	 * @param suggestionSize
	 * @return - true or false
	 * @Description - checks for the visibility of webElement for seconds
	 */
	public static boolean iselementcurrentlyvisibles(List<WebElement> suggestionSize) {
		try {
			WebDriverWait wait = new WebDriverWait(getDriver(), 3);
			wait.until(ExpectedConditions.visibilityOfAllElements(suggestionSize));
			return true;
		} catch (org.openqa.selenium.NoSuchElementException e) {

			return false;

		} catch (org.openqa.selenium.ElementNotVisibleException e) {

			return false;

		} catch (org.openqa.selenium.TimeoutException e) {

			return false;
		}
	}

	/**
	 * @param welement
	 * @Description - scroll into the view of the WebElement
	 */
	public static void scrollintoview(WebElement welement) {

		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", welement);

	}

	/**
	 * @param welement
	 * @Description - scroll into the view of WebElement and click on the WebElement
	 */
	public static void scrollintoviewAndClickonWebElement(WebElement welement) {

		((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", welement);

	}

	/**
	 * @param clickableElement
	 */
	public static void WaitforElementtobeClickable(WebElement clickableElement) {

		WebDriverWait wait = new WebDriverWait(getDriver(), 20);
		wait.until(ExpectedConditions.elementToBeClickable(clickableElement));
	}

	public static boolean iselementcurrentlyvisible(WebElement webobject) {
		try {
			WebDriverWait wait = new WebDriverWait(getDriver(), 3);
			wait.until(ExpectedConditions.visibilityOf(webobject));
			return true;
		} catch (org.openqa.selenium.NoSuchElementException e) {

			return false;

		} catch (org.openqa.selenium.ElementNotVisibleException e) {

			return false;

		} catch (org.openqa.selenium.TimeoutException e) {

			return false;
		}
	}

	public static boolean iselementcurrentlyenable(WebElement webobject) {
		try {
			WebDriverWait wait = new WebDriverWait(getDriver(), 3);
			wait.until(ExpectedConditions.elementToBeClickable(webobject));
			return true;
		} catch (org.openqa.selenium.NoSuchElementException e) {

			return false;

		} catch (org.openqa.selenium.TimeoutException e1) {
			return false;
		}
	}
	
	public static void highlightUIElement(WebElement element) {
		
		
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
		 
		try 
		{
		Thread.sleep(1000);
		} 
		catch (InterruptedException e) {
		 
		System.out.println(e.getMessage());
		} 
		 
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].setAttribute('style','border: solid 2px white');", element); 	 
		
	}

	public static void captureScreenshot(String screenshotPath) throws InterruptedException {

		Thread.sleep(2000);

		File scrFile2 = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrFile2, new File(screenshotPath));

		} catch (IOException e) {

			e.printStackTrace();
		}
	}
	
	public static boolean checkElementisClickable(WebElement welement) {

		try {
		WebDriverWait wait = new WebDriverWait(getDriver(), 200);
		wait.until(ExpectedConditions.elementToBeClickable(welement)) ;
		return true;
		
			} catch (org.openqa.selenium.NoSuchElementException e) {

		return false;

			}
	}
	
	@SuppressWarnings("unchecked")
	public static void WaitforElementToDisappear(final WebElement welement) {
		
		WebDriverWait wait = new WebDriverWait(getDriver(), 10);
		ExpectedCondition elementIsDisplayed = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver arg0) {
			  try {
				  welement.isDisplayed();
			     return false;
			  }
			  catch (NoSuchElementException e ) {
			    return true;
			  }
			  catch (StaleElementReferenceException f) {
			    return true;
			  }
			    }
			};
			wait.until(elementIsDisplayed);
	}

	
	
	/**
	 * @param screenshotPath
	 * @throws InterruptedException
	 * @Description - capture screenshot and place it in screenshot Path
	 */
	public static void captureScreenshotOnFailure(String screenshotPath) throws InterruptedException {
		
		Thread.sleep(3000);
	//	highlightUIElement(arg0);

		File scrFile2 = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrFile2, new File(screenshotPath));

		} catch (IOException e) {

			e.printStackTrace();
		}
		
	}
	
	
	/**
	 * @Description - waits till the page is loaded completely with all elements loaded.
	 * after every 1 second the readiness will be checked.
	 */
	public void CheckPageIsReady() {
		
		JavascriptExecutor js = (JavascriptExecutor)SeleniumDriver.getDriver();
	/*	js.executeScript("return document.readyState").toString().equals("complete");
		System.out.println("Page is loaded.");*/
		
		//This loop will rotate for 25 times to check If page Is ready after every 1 second.
		for (int i=0; i<25; i++){ 
			   try {
			    Thread.sleep(1000);
			    }catch (InterruptedException e) {} 
			   //To check page ready state.
			   if (js.executeScript("return document.readyState").toString().equals("complete")){
				   System.out.println("Page is loaded.");
			    break; 
			   }   
			  }
			 

		
		
	}
	
	public static void captureScreenshotwithHighlightedElement(String screenshotPath,WebElement element) throws InterruptedException {

		Thread.sleep(3000);
		highlightUIElement(element);

		File scrFile2 = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrFile2, new File(screenshotPath));

		} catch (IOException e) {

			e.printStackTrace();
		}
	}

}
