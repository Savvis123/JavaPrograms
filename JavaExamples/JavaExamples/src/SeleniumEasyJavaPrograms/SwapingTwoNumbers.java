package SeleniumEasyJavaPrograms;

import java.util.Scanner;

public class SwapingTwoNumbers {

	public static void main(String[] args) {
		
		// taking input from user
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the 1st number: ");
		int x = in.nextInt();
		System.out.println("Enter the 2nd number: ");
		int y = in.nextInt();
		 
		// printing values before swap
		System.out.println("Before Swap: ");
		System.out.println("Value of x: "+x);
		System.out.println("Value of y: "+y);
		
		// swapping without using third variable
		x = x+y;
		y = x-y;
		x = x-y;
		 
		// printing values after swap
		System.out.println("After Swap: ");
		System.out.println("Value of x: "+x);
		System.out.println("Value of y: "+y);
	}
}