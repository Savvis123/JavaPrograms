package WebTableExamples;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PracticeWebtableReadData {

	public static void main(String[] args) {
    	WebDriver driver;
    	System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\ab64129\\Desktop\\NaveenAutomationLabsRestAPI\\AutomationPractice\\src\\test\\resources\\chromedriver.exe");
	
        driver = new ChromeDriver();
    	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    	driver.get("http://demo.guru99.com/test/table.html");

        WebElement mytable=driver.findElement(By.xpath("/html/body/table/tbody"));
        
        List<WebElement> rows=mytable.findElements(By.tagName("tr"));
        int rowscount=rows.size();
        
        for(int row=0;row<rowscount;row++)
        {
        
        	List<WebElement> columns=rows.get(row).findElements(By.tagName("td"));
        	int columnscount=columns.size();
        	for(int column=0;column<columnscount;column++)
        	{
        		String celltext=columns.get(column).getText();
        		System.out.println(celltext);
        		 System.out.print("Cell Value of row number " + row + " and column number " + column + " Is " + celltext);
          	   
        	}
        	System.out.println("------------------");
        }
    	
    	
	}

}
