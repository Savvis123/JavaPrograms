package OnlineRostorJavaPrograms;

import java.util.HashMap;

public class GetKeyFromHashMap {

	public static void main(String[] args) {
	
		HashMap<String,Integer> map=new HashMap<String,Integer>();
		map.put("fistnumber", 1);
		map.put("seconnumber",2);
		
		//first way-- it works when we have only one pair
		System.out.println(map.keySet().toArray()[0]);
	
		//second way 
		for(String key:map.keySet())
		{
			System.out.println(key);
		}

	}

}
