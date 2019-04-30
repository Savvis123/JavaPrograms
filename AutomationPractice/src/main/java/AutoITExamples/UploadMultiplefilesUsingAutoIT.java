package AutoITExamples;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

/*If you focus on line number 2 where I have used $CmdLine[1] this is the way to pass parameter at run time.

In the same way, we can pass multiple arguments in AutoIT.

Example are-

$CmdLine[0] ; Contains the total number of items in the array.
$CmdLine[1] ; The first parameter.
$CmdLine[2] ; The second parameter.
$CmdLine[nth] ; The nth parameter e.g. 10 if the array contains 10 items.

controlFocus-- title , text , controlID-------->classname+instance 

controlsetText --- title , text, controlID , file--->filepath

ControlClick --- title , text , controlID

Text ----is optional
ControlID= class+instance(Edit1-----here Edit is class name and 1 is the Instance)

$CmdLine[1] -----is the one to use to upload multiple file --parameterize (through command prompt)

 */

	public class UploadMultiplefilesUsingAutoIT {
	@Test
	public void uploaMultipleFiles() throws Throwable
	{
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\ab64129\\Desktop\\NaveenAutomationLabsRestAPI\\AutomationPractice\\src\\test\\resources\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://rte1vfo.corp.intranet/login.jsp");
	
	driver.get("file:///C:\\Users\\ab64129\\Desktop\\NaveenAutomationLabsRestAPI\\HandlingAuth\\Upload.html");

	driver.findElement(By.xpath(".//*[@id='1']")).click();

	Runtime.getRuntime().exec("C:\\Users\\ab64129\\Desktop\\NaveenAutomationLabsRestAPI\\HandlingAuth\\fileUpload3.exe"+" "+"C:\\Users\\ab64129\\Desktop\\NaveenAutomationLabsRestAPI\\HandlingAuth\\AppiumHowToLaunchMobileApp.docx");

	Thread.sleep(2000);

	driver.findElement(By.xpath(".//*[@id='1']")).click();

	Thread.sleep(2000);

	Runtime.getRuntime().exec("C:\\Users\\ab64129\\Desktop\\NaveenAutomationLabsRestAPI\\HandlingAuth\\fileUpload3.exe"+" "+"C:\\Users\\ab64129\\Desktop\\NaveenAutomationLabsRestAPI\\HandlingAuth\\NewTextDocument.txt");
	}
	}


