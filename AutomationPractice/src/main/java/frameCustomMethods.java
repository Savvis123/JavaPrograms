import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class frameCustomMethods {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		
		int number =findswitchToFrame(driver, By.xpath("//input[@name='mahesh']"));
		driver.switchTo().frame(number);
		driver.findElement(By.xpath("//input[@name='mahesh']")).click();

	}
	
	public static int findswitchToFrame(WebDriver driver,By by)
	{
		int i;
		int framecount=driver.findElements(By.tagName("iframe")).size();
		for(i=0;i<framecount;i++)
		{
			driver.switchTo().frame(i);
			
			int count=driver.findElements(by).size();
			if(count>0)
			{
				driver.findElement(by).click();
				break;
			}
			else
				
			{
				System.out.println("continue looping");
			}
		}
		
		driver.switchTo().defaultContent();
		return i;
		
	}

}
