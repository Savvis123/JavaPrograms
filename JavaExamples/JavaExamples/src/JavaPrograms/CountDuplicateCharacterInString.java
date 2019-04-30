package JavaPrograms;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class CountDuplicateCharacterInString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String str="maheshreddy";
		Map<Character,Integer> dupmap=new HashMap<>();
		char chars[]=str.toCharArray();
		for(Character ch : chars)
		{
			if(dupmap.containsKey(ch))
			{
				dupmap.put(ch,dupmap.get(ch)+1);
			}
			else
			{
				dupmap.put(ch,1);
			}
		}

		Set<Character> keys=dupmap.keySet();
		for(Character ch:keys)
		{
			if(dupmap.get(ch)>1)
			{
				System.out.println(ch+"--->"+dupmap.get(ch));
			}
		}
		
	}

}
