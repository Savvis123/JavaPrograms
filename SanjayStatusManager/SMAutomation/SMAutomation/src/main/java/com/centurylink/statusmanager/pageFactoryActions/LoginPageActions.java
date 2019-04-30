package com.centurylink.statusmanager.pageFactoryActions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.codec.binary.Base64;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import com.centurylink.statusmanager.utilities.CommonMethods;
import com.centurylink.statusmanager.utilities.SeleniumDriver;
import com.centurylink.statusmanager.utilities.URLConfigs;

@SuppressWarnings("unused")
public class LoginPageActions {

	WebDriver driver;
	
	private final static org.slf4j.Logger Log = LoggerFactory.getLogger(LoginPageActions.class);
	
	FileInputStream fis ;
	Properties prop = new Properties();
	
	
	@FindBy(id = "user")
	public WebElement username_tbx;

	@FindBy(id = "password")
	public WebElement password_tbx;

	@FindBy(xpath = ".//button[@ng-click='login()']")
	public WebElement signIn_btn;
	
	@FindBy(how= How.XPATH, using =".//*[@ng-class='alert.className']")
	public WebElement SingInAlert_lbl ;

	//
	@FindBy(how = How.XPATH, using = "//button[@ng-click='login()']")
	public WebElement ndSingIn_2format;

	// ******************* Default Constructor  *************************
	public LoginPageActions(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(SeleniumDriver.getDriver(), this);
	}

	// ************************  Page methods  **************************
	public void fillLoginForm() throws IOException, InterruptedException {
		
		fis = new FileInputStream(URLConfigs.BASE_FILE_PATH) ;
		prop.load(fis);

		String str = prop.getProperty("password");
		byte[] decodedPwdBytes = Base64.decodeBase64(str.getBytes());

		String decodedPwd = new String(decodedPwdBytes);
		username_tbx.sendKeys(prop.getProperty("username"));
		password_tbx.sendKeys(decodedPwd);
		CommonMethods.captureScreenshot(URLConfigs.SCREENSHOT_PATH + "\\SM_LoginPage" + "_" + SeleniumDriver.timestamp() + ".png");
		

	}

	public void performSignIn() {

		signIn_btn.click();
	//	validateSignInAlert1();
		
	/*	if (CommonMethods.iselementcurrentlyvisible(SingInAlert_lbl)) {
				validateSignInAlert();
		}*/
	}
	
	
	// ----------------------------------------------------------
	
/*	
	public void validateSignInAlert () {
		
		String actualLabel = SingInAlert_lbl.getText().trim() ;
		
		String invalidCredentials = "Please enter valid CUID/Password." ; 
		
		if (actualLabel.contains(invalidCredentials)) {
			
			try {
				Assert.fail(actualLabel);
			throw new Exception(actualLabel);
			
			
			} catch (Exception e) {
				
				e.printStackTrace();
			}
		}else {
			
			try {
				Assert.fail(actualLabel);
				throw new Exception(actualLabel);
			} catch (Exception e) {
				
				e.printStackTrace();
			}
		}
			
	}
	
	
	public void validateSignInAlert1() {
		
		boolean signInAlertStatus = CommonMethods.iselementcurrentlyvisible(SingInAlert_lbl) ;
		
		System.out.println("signInAlertStatus =" + signInAlertStatus);

		if (signInAlertStatus == true) {
			
			String actualLabel = SingInAlert_lbl.getText().trim() ;
			
			String invalidCredentials = "Please enter valid CUID/Password." ; 
		
			Assert.fail(actualLabel);
			
		}
	}
	*/
	
	// ----------------------------------------------------------
		
}
