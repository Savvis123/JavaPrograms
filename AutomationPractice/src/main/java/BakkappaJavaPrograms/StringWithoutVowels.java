package BakkappaJavaPrograms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class StringWithoutVowels {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	/*	Scanner sc=new Scanner(System.in);
		System.out.println("enter a string");
		String stringwithvowels=sc.nextLine();
		String stringwithoutvowels=stringwithvowels.replaceAll("[AEIOUaeiou]","");
		System.out.println(stringwithoutvowels);*/
		
		String s="mahesh";
		
		    StringBuilder sb = new StringBuilder();
		    Set<Character> vowels = new HashSet<Character>();
		    vowels.add('a');
		    vowels.add('A');
		    vowels.add('e');
		    vowels.add('E');
		    vowels.add('i');
		    vowels.add('I');
		    vowels.add('o');
		    vowels.add('O');
		    vowels.add('u');
		    vowels.add('U');
		    
		  
		    for (int i = 0; i < s.length(); i++) {
		        char c = s.charAt(i);
		        if (!vowels.contains(c)) {
		            sb.append(c);
		        }
		    }
		    System.out.println(sb.toString());
		    
		    
		    
		    String input = "suresh";
		    int f = 0;

String str="";
		    for(int i = 0; i < input.length(); i++){
		    	
		   char c=input.charAt(i);

		        if(c == 'a'||c == 'e'||c == 'i'||c == 'o'||c =='u' ||c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U')
		            f = 1;
		        else{
		            str = str + c;
		           
		        }
		    }
		    
		    System.out.println(str);
	}

}
