package OnlineRostorJavaPrograms;

import java.util.HashMap;
import java.util.Map;

public class DuplicateCharactersFromString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String str="programming";
		char[] arr=str.toCharArray();
		Map<Character,Integer> map=new HashMap<Character,Integer>();
		int count=1;
		for(int i=0;i<arr.length;i++)
		{
			if(!map.containsKey(arr[i]))
			{
				map.put(arr[i],count);
			}
			else
			{
				map.put(arr[i], map.get(arr[i])+1);
				
			}
		}

		
		for(Character ch:map.keySet())
		{
			//System.out.println(ch+"------"+map.get(ch));
			if(map.get(ch)==1)
			{
				System.out.println(ch+"------"+map.get(ch));
			}
		}
	}

}
