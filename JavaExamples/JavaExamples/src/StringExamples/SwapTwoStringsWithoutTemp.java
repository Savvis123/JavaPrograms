package StringExamples;

public class SwapTwoStringsWithoutTemp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String a="Hello";
		String b="World";
		System.out.println("Before swapping");
		
		System.out.println("value of string a is :"+a);
		System.out.println("value of string b is :"+b);
		
		//1. append a and b
		a=a+b;
		System.out.println(a);
		System.out.println(a.length());
		//2.Store initial string a in string b
		System.out.println(a.length()-b.length());
		
		b=a.substring(0,a.length()-b.length());
		a=a.substring(b.length());
		
       System.out.println("After swapping");
		
		System.out.println("value of string a is :"+a);
		System.out.println("value of string b is :"+b);

	}

}
