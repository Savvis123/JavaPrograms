package SeleniumInterviewQuestions;

import java.util.Scanner;

public class ReversePyramid {

	public static void main(String[] args) {

       System.out.println("enter a number");
		Scanner sc=new Scanner(System.in);
       
      int n=sc.nextInt();
      
      int k=2*n-2;
      
      for(int i=0;i<n;i++)
      {
    	  
    	  for(int j=0;j<k;j++)
    	  {
    		  System.out.print(" ");
    	  }
    	  k=k-2;
    	  for(int j=0;j<=i;j++){
    		  
    		  System.out.print("* ");
    	  }
    	 
    	  System.out.println(); 
      }
		
      
	}

}
