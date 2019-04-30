package practiceForInterview;

import java.util.HashMap;

public class AccerenceOfEachCharacterInString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String str="maheshmreddyh";
		char[] arr=str.toCharArray();
		HashMap<Character,Integer> map=new HashMap<>();
		for(char ch:arr){
			if(map.containsKey(ch))
			{
				int val=map.get(ch);
				map.put(ch, val+1);
			}
			else
			{
				map.put(ch, 1);
			}
		}

	System.out.println(map);
	}
	

}
