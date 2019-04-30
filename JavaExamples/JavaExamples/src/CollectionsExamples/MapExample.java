package CollectionsExamples;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MapExample {

	public static void main(String[] args) {
		// it will allow one null key and if you insert one more then it will point to latest one
		//if you enter duplicate values it will allow but display only one time
		
		Map<Integer,String> hashMap=new HashMap<>();
		hashMap.put(1,"QA");
		hashMap.put(2,"BA");
		hashMap.put(3,"DEV");
		hashMap.put(null, "SM");
		hashMap.put(null, "Manager");
		hashMap.put(1, "QA");
		System.out.println("elements from map:"+hashMap);
		
		//to retrieve keys
		Set<Integer> keySet = hashMap.keySet();
        Iterator<Integer> itr = keySet.iterator();
        while (itr.hasNext())
        {
            System.out.print(itr.next() + "\t");
        }
        
        System.out.println();
        
    	//entryset --- to retrieve values and keys
        Set<Entry<Integer, String>> entryset=hashMap.entrySet();
        
        Iterator<Entry<Integer,String>> iterator=entryset.iterator();
        while(iterator.hasNext())
        {
        	System.out.println(iterator.next());
        }
        
        // to retrieve values
        Collection<String> collectionValues = hashMap.values();
        Iterator it= collectionValues.iterator();
        while (it.hasNext())
        {
            System.out.print(it.next() + "\t");
        }
   
        
        System.out.println("the hash Map contains Key 3 :" + hashMap.containsKey(3));
        System.out.println("the hash Map contains Value 600 :" + hashMap.containsValue(600));
        System.out.println("the size of the hash Map is " + hashMap.size());
        //hashMap.clear();
        if (hashMap.isEmpty())
            System.out.println("the hash Map is empty");
        else
            System.out.println("the hash Map is not empty");
        
	}


	
	
	
	
}
