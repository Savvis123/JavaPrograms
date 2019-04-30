package bhanuPratapJavaPrograms;

import java.util.HashMap;

public class FindLongestSubStringLength {

	public static int findLengthOfLongestSubString(String s) {
		// TODO Auto-generated method stub
		
		int len=0;
		
		String str="maheshreddy";
		char charArray[]=s.toCharArray();
		
		HashMap<Character,Integer> map=new HashMap<>();
		for(int i=0;i<charArray.length;i++)
		{
			if(!map.containsKey(charArray[i]))
			{
				map.put(charArray[i],i);
			}
			else
			{
				len=Math.max(len, map.size());
				map.clear();
			}
		}

		
		return Math.max(len, map.size());
		
	}

	
	public static void main(String[] args) {
		System.out.println(findLengthOfLongestSubString("mahesh m a"));
	}
}
