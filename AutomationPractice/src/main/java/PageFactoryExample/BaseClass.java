package PageFactoryExample;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class BaseClass {
	
	public BaseClass(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

}
