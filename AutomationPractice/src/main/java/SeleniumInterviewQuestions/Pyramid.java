package SeleniumInterviewQuestions;

import java.util.Scanner;

public class Pyramid {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("enter a number to print pyramid");
		Scanner sc=new Scanner(System.in);
		
		int n=sc.nextInt();
		
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<=i;j++){
				System.out.print("* ");
			}
		System.out.println();
		}

	}

}
