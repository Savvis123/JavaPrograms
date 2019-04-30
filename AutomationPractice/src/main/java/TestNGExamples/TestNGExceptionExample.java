package TestNGExamples;

import org.testng.annotations.Test;

public class TestNGExceptionExample {
	
	@Test(expectedExceptions=ArithmeticException.class)
	public void sample()
	{
		int i=1/0;
		System.out.println("value of i is:"+i);
	}
	
	@Test(timeOut=5000)
	public void timeOutExample() throws InterruptedException
	{
		Thread.sleep(4000);
		System.out.println("this is mahesh");
	}
	
	//skip the test
	@Test(enabled=false)
	public void ignoreTest()
	{
		System.out.println("testing");
	}
	
	
	
	
	@Test(dependsOnMethods={"sample"})
	public void depedencyFeature()
	{
		System.out.println("depending feature testing");
	}

	@Test(groups="sanity")
	public void groupsExaple()
	{
		System.out.println("sanity-Testing method");
	}
	
	
	@Test(groups={"regression"})
	public void regressionExample()
	{
		System.out.println("regression-Testing method");
	}
	
	@Test(groups={"regression","sanity"})
	public void regressionSanityExample()
	{
		System.out.println("regression-Testing method");
	}
	
	@Test(priority=0)
	public void testPriority()
	{
		System.out.println("test priority");
	}
	
	@Test(priority=1)
	public void testPriority1()
	{
		System.out.println("test priority1-------");
	}
	
	
}
