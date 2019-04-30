package OnlineRostorJavaPrograms;

import edu.emory.mathcs.backport.java.util.Arrays;

public class Anagram {

	public static void main(String[] args) {
		// Anagram mean same characters in both words ,but word meaning is different
		String str="army";
		String str1="mary";
		char arr[]=str.toLowerCase().toCharArray();
		char arr1[]=str1.toLowerCase().toCharArray();
		Arrays.sort(arr);
		Arrays.sort(arr1);
		if(Arrays.equals(arr, arr1))
		{
			System.out.println("given strings are anagrams");
		}
		else
		{
			System.out.println("given strings are not anagram");
		}
		

	}

}
