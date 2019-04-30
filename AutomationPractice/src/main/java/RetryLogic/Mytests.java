package RetryLogic;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Mytests {

	@Test(retryAnalyzer=RetryLogic.RetryAnalizer.class)
	public void test1()
	{
		Assert.assertEquals(false, true);
	}
	
	@Test
	public void test2()
	{
		Assert.assertEquals(false, true);
	}
	
}
