package TestNGExamples;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertionsExamples {
	
	SoftAssert soft=new SoftAssert();
	
	//hard assertion - if it gets failed next step will not get execute and test execution will terminate
	
	//softassertions - test execution will continue even if home page validation fail also ,some time home page is visibile ect..
	
	@Test
	public void loginToApplication()
	{
		
		System.out.println("open Browser");
		//Assert.assertEquals(true,false);
		System.out.println("logged into application");
		//Assert.assertEquals(true,false);
		System.out.println("validated home page");
		soft.assertEquals(true, false);
		
		System.out.println("validated customer info page");
		soft.assertEquals(true, false);
		System.out.println("validated products and pricing page");
		soft.assertEquals(true, false);
		System.out.println("validated billing address validation page");
		soft.assertEquals(true, false);
		System.out.println("validated billing application page");
		soft.assertAll();
		
	}

}
