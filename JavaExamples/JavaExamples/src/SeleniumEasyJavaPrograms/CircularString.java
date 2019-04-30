package SeleniumEasyJavaPrograms;

import java.util.Scanner;

public class CircularString {

	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter words separated by space:");
		String input= sc.nextLine();
		System.out.println("Enter position:");
		int index=sc.nextInt();
		// Splitting input string in to string array
		String inputArray[]= input.split(" ");
		// validation for acceptable index
		// index should be grater than or equal to zero and less than length of array
		if(index>=0 && index <inputArray.length)
		{
			System.out.print("Output: ");
			// Printing from given index till last index
			for(int i=index;i<inputArray.length;i++)
			{
				System.out.print(inputArray[i]+" ");
			}
			// printing from index zero to position-1
			for(int k=0;k<index;k++)
			{
				System.out.print(inputArray[k]+" ");
			}
		}
		else
		{
			System.out.println("Index is invalid.");
		}
	}

}
