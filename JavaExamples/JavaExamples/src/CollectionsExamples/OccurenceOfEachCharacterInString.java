package CollectionsExamples;

import java.util.HashMap;
public class OccurenceOfEachCharacterInString {
	public static void main(String[] args) {
		String str = "Programming";
	/*	HashMap<Character, Integer> map = new HashMap<>();
		for (char ch : str.toCharArray()) {
			if (map.containsKey(ch)) {
				int val = map.get(ch);
				map.put(ch, val + 1);
			} else {
				map.put(ch, 1);
			}
		}
		System.out.println(map);*/
		
		int count =0;
		int i,j;
		char m;
		for(i=0;i<str.length()-1;i++)
		{
			for(j=i+1;j<str.length()-1;j++)
			{
				if(str.charAt(i)==str.charAt(j))
				{
					count++;
					
				}
				
				
				
			}
			
			
			
			if(count>=2)
			{
			m=str.charAt(j);
			System.out.println(m);
			}	
		}
		
		
	}
}