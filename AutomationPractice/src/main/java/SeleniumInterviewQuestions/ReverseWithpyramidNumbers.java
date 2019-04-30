package SeleniumInterviewQuestions;

import java.util.Scanner;

public class ReverseWithpyramidNumbers {

public static void main(String args[])
{
	

		
		System.out.println("enter a number to print pyramid");
		Scanner sc=new Scanner(System.in);
		
		int n=sc.nextInt();
		
		for(int i=1;i<=n;i++)
		{
			for(int j=i;j>=1;j--){
				System.out.print(j+" ");
			}
		System.out.println();
		}

	}      
	      
		}

	


