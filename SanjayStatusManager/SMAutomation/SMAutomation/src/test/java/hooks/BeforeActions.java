package hooks;

import com.centurylink.statusmanager.utilities.SeleniumDriver;

import cucumber.api.Scenario;
import cucumber.api.java.Before;

public class BeforeActions {

	static Scenario scenario ;
	
	@Before
    public static void setUp() {
		//ExtentCucumberFormatter.initiateExtentCucumberFormatter();
    	System.out.println("Before");
     //  SeleniumDriver.setupDriver();
    }
	
	@Before
	public static String retrunscenariostatus() {

		String a = scenario.getId();
		String b = scenario.getName();
		String res = a+"_"+b ;
		System.out.println("scenario.getId() = "+ scenario.getId());
		System.out.println("scenario.getName() = "+ scenario.getName());
		return res;
	}


}
