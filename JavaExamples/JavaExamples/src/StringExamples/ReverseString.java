package StringExamples;

import java.awt.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ListIterator;

public class ReverseString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Using for loop
		String str="mahesh";
		String reverse="";
		for(int i=str.length()-1;i>=0;i--)
		{
			reverse=reverse+str.charAt(i);
			
		}
		System.out.println(reverse);
		
		
		//2. Using StringBuffer
		
		StringBuffer sbf=new StringBuffer();
		sbf.append(str);
		sbf.reverse();
		System.out.println("Using stringBuffer reverse value is :"+sbf);
		
		//3.Using Character Array
		
		char ch[]=str.toCharArray();
		
		String st="";
		
		for(int i=ch.length-1;i>=0;i--)
		{
			st=st+ch[i];
		}
		
		System.out.println("String using characterArray :"+st);
		
		
		
		//4.Using Collections(ArrayList Object)
		
		char arr[]=str.toCharArray();
		ArrayList<Character> al = new ArrayList<Character>();
		
		for(char character:arr){
			al.add(character);
		}
		
		Collections.reverse(al);
		
		String rev="";
		
		ListIterator li=al.listIterator();
		{
			while(li.hasNext())
			{
				rev=rev+li.next();
			}
			
		}
		System.out.println("Using collections string reverse :"+rev);
		
	}

}
