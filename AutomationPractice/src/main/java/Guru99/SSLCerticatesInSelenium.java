package Guru99;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

public class SSLCerticatesInSelenium {
	
	WebDriver driver;
	
	
	@Test
	public void FFSSL()
	{
	ProfilesIni pf=new ProfilesIni();
	FirefoxProfile ffprofile=pf.getProfile("myprofile");
	ffprofile.setAcceptUntrustedCertificates(true);;
	ffprofile.setAssumeUntrustedCertificateIssuer(false);
	
	//driver = new FirefoxDriver(ffprofile) ;
	}
	
	@Test
	public void ChromeSSL()
	{
		
		DesiredCapabilities capabilities=new DesiredCapabilities();
		capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		driver=new ChromeDriver(capabilities);
	}

	
	@Test
	public void IESSL()
	{
		//first way
		driver.navigate ().to ("javascript:document.getElementById('overridelink').click()");
		//The second method is quite similar to chrome SSL Handling code
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		System.setProperty("webdriver.ie.driver","IEDriverServer.exe");
		WebDriver driver = new InternetExplorerDriver(capabilities);
	}
}
