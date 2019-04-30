package ArraysExamples;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FindDuplicatesInStringArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String names[]={"java","C","python","java","mahesh","siva","mahesh"};
		
	//first way
		for(int i=0;i<names.length;i++)
		{
			for(int j=i+1;j<names.length;j++)
			{
				if(names[i].equals(names[j]))
				{
					System.out.println("duplicate elements are:"+names[i]);
				}
			}
		}
		
		System.out.println("############################");
		
		//second way Using collections set
		
		Set<String> set=new HashSet<>();
		for(String name:names)
		{
			if(set.add(name)==false)
			{
				System.out.println("printing duplicate elements using collection :"+name);
			}
		}
		
		
		System.out.println("############### third way #################");
		//Using hashmap 
	
		Map<String,Integer> map=new HashMap<String,Integer>();
		for(String name:names)
		{
			Integer count=map.get(name);
			if(count == null)
			{
				map.put(name, 1);
			}
			else
			{
				map.put(name,++count);
			}
		}
		
		Set<java.util.Map.Entry<String, Integer>> entryset=map.entrySet();
		
		for(java.util.Map.Entry<String, Integer> entry:entryset)
		{
			if(entry.getValue()>1)
			{
				System.out.println("duplicate elements using hashmap :"+entry.getKey());
			}
		}
		
		
		
		

	}

}
