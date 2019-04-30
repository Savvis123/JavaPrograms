package SeleniumEasyJavaPrograms;


	import java.util.Scanner;

	public class StringPalindrome 
	{
	public static void main(String[] args) {
		
		// Taking input from user
		Scanner sc= new Scanner(System.in);
		System.out.println("Please enter the string to know palindrome:");
		String inputByUser= sc.nextLine();
		//Converting String in to StringBuilder
		StringBuilder strOriginal= new StringBuilder(inputByUser);
		// reversing string
		StringBuilder strReverse= new StringBuilder(strOriginal).reverse();
		//since stringBuildr/Buffer do not override equals method so it will not check content
		//To verify content we can use valueOf method of String class. This method class toString() internally.
		if(String.valueOf(strOriginal).equals(String.valueOf(strReverse)))
			System.out.println("Result:Palindrome");
		else
		    System.out.println("Result:Not Palindrome");
		//Another way to verify content  using toString()
		 if((strOriginal.toString()).equals(strReverse.toString()))
			System.out.println("Result:Palindrome");
		 else
			System.out.println("Result:Not Palindrome");
		 //Using compareTo method
		 if((strOriginal.toString()).compareTo(strReverse.toString())==0)
			System.out.println("Result:Palindrome");
		 else
			System.out.println("Result:Not Palindrome");
			 
			    
	}
	}
