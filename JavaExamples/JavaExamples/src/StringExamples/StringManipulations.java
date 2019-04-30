package StringExamples;

public class StringManipulations {

	public static void main(String[] args) {
		
		String s="  maheshreddy12345m mahy  ";
		String s1="maheshreddy12345m mahy";
		String s2="Maheshreddy12345m mahy";
		
		System.out.println("length of string is:"+s.length());
		
		//find character from string using index
		
		System.out.println("find character from string using index:"+s.charAt(7));
		
		//find the index of character from string
		//first occurance
		
		System.out.println("find the index of character from string:"+s.indexOf('d'));
		
		//second occurance
		
		System.out.println("second occurance of character from string:"+s.indexOf('m',s.indexOf('m')+1));
		
		System.out.println("find the index from the given index"+s.indexOf('m',3));
		
		System.out.println("get the index of word from a string :"+s.indexOf("mahy"));
		
		//if it return -1 then character not present in string
		System.out.println("check the presence of character or word:"+s.indexOf('z'));
		
		//string comparision 
		//if returns true then both strings are same 
		//java is case sensitive
		
		System.out.println(s.equals(s1));//true
		System.out.println(s.equals(s2)); //False
		System.out.println(s.equalsIgnoreCase(s2));//true
		
		
		//you can print any substring from string
		
		System.out.println("sub string from main string is:"+s.substring(0,11));
		
		//trim -- remove before space and after space
		
		System.out.println("string value after trim:"+s.trim());
		
		
		String st="   hello   world    ";
		//replace -- you can use to remove space from any where
		System.out.println("remove space from entire string :"+st.replace(" ", ""));
		
		String date="01-07-1987";//01/07/1987
		System.out.println(date.replace("-","/"));
		
		//split -- after split string based on some condition it will return array
		
		String test="hello_world_selenium_automation";
		String arr[]=test.split("_");
		for(int i=0;i<arr.length;i++)
		{
			System.out.println("string elements are :"+arr[i]);
		}

		//concatenate---to combine two strings
		
		System.out.println(s.concat(s2));
		
		
		String x="hello";
		String y="world";
		System.out.println(x+y);
		int a=100;
		int b=200;
		System.out.println(a+b);
		System.out.println(x+y+a+b);
		System.out.println(a+b+x+y);
		System.out.println(x+y+(a+b));
		
	}

}
