package Loops;

public class ForLoopExample {

	public static void main(String[] args) {
	
		//printing 1 to 10 
		for(int i=1;i<=10;i++)//initialization conditional incremental
		{
			
			System.out.println(i);
		}
		
		//printing 10 to 1
		
		for (int j=10;j>=1;j--)//initialization conditional decremental
		{
			System.out.println(j);
		}
		
		//printing from 10 to -10
		
		for (int k=10;k>=-10;k--)//initialization conditional decremental
		{
			System.out.println(k);
		}
		
		//post increment - x value is given to y first and it will increment the valie of x o/p: x=2 and y =1
		
		int x=1;
		int y=x++;
		System.out.println(x);
		System.out.println(y);
		
		//pre increment -- a value is increased to 2 and then its gave same value to b--- o/p: a=2 and b=2
		
		int a=1;
		int b=++a;
		System.out.println(a);
		System.out.println(b);
		
		
		//post decrement - m value is given to n first and it will decrement the valie of m o/p: m=1 and n=2
		
				int m=2;
				int n=m--;
				System.out.println("value of m is:"+m);
				System.out.println("value of n is:"+n);

	   //pre decrement -- a value is increased to 2 and then its gave same value to b--- o/p: a=2 and b=2
				
				int c=2;
				int d=--c;
				System.out.println("value of c is:"+c);
				System.out.println("value of d is:"+d);
	}

}
