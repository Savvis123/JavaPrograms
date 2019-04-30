package AccentureKT;
import  java.lang.System.*;
import java.util.Map;
import java.util.Set;

import cucumber.api.Scenario;

public class Soprano {
	
    
    @SuppressWarnings("unused")
	private String getFeatureFileNameFromScenarioId(Scenario scenario) {
        String featureName = "Feature ";
        String rawFeatureName = scenario.getId().split(";")[0].replace("-"," ");
        featureName = featureName + rawFeatureName.substring(0, 1).toUpperCase() + rawFeatureName.substring(1);

        return featureName;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//System.getenv(name)
		
		
		Map<String, String> gfg = System.getenv();
        Set<String> keySet = gfg.keySet();
        for(String key : keySet)
        {
            System.out.println("key= " + key);
        }


	}

}
