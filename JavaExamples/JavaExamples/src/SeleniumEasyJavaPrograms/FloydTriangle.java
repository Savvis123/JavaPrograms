package SeleniumEasyJavaPrograms;

import java.util.Scanner;

public class FloydTriangle {

	public static void main(String[] args) {
		
		// input for number of rows
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the number of rows: ");
		int r = in.nextInt();
		int k=1;
		System.out.println("Floyd Triangle of rows: "+r);
		// for number of rows
		for(int i=1;i<=r;i++)
		{
			// for no of columns in each row
			for(int j=1;j<=i;j++)
			{
				System.out.print(k+++" ");
			}
			System.out.println();
		}
	}
}