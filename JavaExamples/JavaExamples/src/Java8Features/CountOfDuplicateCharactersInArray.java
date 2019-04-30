package Java8Features;

import java.util.HashMap;
import java.util.Set;

public class CountOfDuplicateCharactersInArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s="maheshmh";
		
		HashMap<Character,Integer> map=new HashMap<>();
		char chars[]=s.toCharArray();
		
		for(Character ch:chars)
		{
			if(map.containsKey(ch))
			{
				map.put(ch,map.get(ch)+1);
			}
			else
			{
				map.put(ch,1);
			}
		}
		
		Set<Character> keys=map.keySet();
		for(Character ch:keys)
		{
			if(map.get(ch)>1)
			{
				System.out.println(ch+"--->"+map.get(ch));
			}
		}

	}

}
