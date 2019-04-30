package TestNGExamples;

import org.testng.Reporter;

import org.testng.annotations.Test;

public class TestNGPriority {
	
	
	@Test(priority = 0)
	public void firstmethod()
	{
		System.out.println("first method");
	}
	
	@Test(priority = 1)
	public void secondmethod()
	{
		System.out.println("second method");
	}
	
	@Test(priority = -1)
	public void thirdmethod()
	{
		System.out.println("thirdmethod -1");
	}
	@Test(invocationCount=3)
	public void fourthmethod()
	{
		System.out.println("invocationCount method");
		
		Reporter.log("this is used to enter log info in TestNG report");
	}

}
