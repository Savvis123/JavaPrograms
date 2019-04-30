package TestNGExamples;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNGparameters {
	
	@BeforeTest
	public void beforeTestExample()
	{
		System.out.println("Before Test Message");
	}
	
	
	@AfterTest
	public void afterTestExample()
	{
		System.out.println("After Test Message");
	}
	@Test
	@Parameters({"Browser"})
	public void test1(String Browser)
	{
		System.out.println("first test method");
	}

	

	@Test
	@Parameters({"Browser"})
	public void test2(String Broswer)
	{
		System.out.println("second test method");
	}
	

	@Test
	public void test3()
	{
		System.out.println("third test method");
	}
}
