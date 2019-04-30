package BakkappaJavaPrograms;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicatedfromString {

	public static void main(String[] args) {
		String s="javaprograming";
		
		char[] ch=s.toCharArray();
		
		Set set=new HashSet();
		
		StringBuffer removedups=new StringBuffer();
		
		for(char character : ch)
		{
		
			if(set.add(character))
			{
				removedups.append(character);
			}
		}
		
		System.out.println(removedups);
	}

}
