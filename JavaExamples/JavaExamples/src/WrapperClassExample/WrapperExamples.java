package WrapperClassExample;

public class WrapperExamples {

	public static void main(String[] args) {
	//wrapper class is used to data conversion from one data type to another data type
		String s="100";
		int i=Integer.parseInt(s);
		System.out.println("value of i is :"+i);
		
		//string to boolean
		String s1="true";
		boolean b=Boolean.parseBoolean(s1);
		System.out.println("value of b is :"+b);
		
		//string to double
		
		String s2="12.33";
		double d=Double.parseDouble(s2);
		System.out.println("value of d is "+d);
		
		//int to string 
		
		int x=200;
		String string=String.valueOf(x);// value is "200"
		System.out.println("value of converted string is "+string+20);//concatinating 20 to "200"
		
		//Number format Exception 
		/*
    Exception in thread "main" java.lang.NumberFormatException: For input string: "100a"
	at java.lang.NumberFormatException.forInputString(Unknown Source)
	at java.lang.Integer.parseInt(Unknown Source)
	at java.lang.Integer.parseInt(Unknown Source)
	at WrapperClassExample.WrapperExamples.main(WrapperExamples.java:31)

		 */
		
		String ss="100a";
		int k=Integer.parseInt(ss);
		System.out.println(k);
		

	}

}
