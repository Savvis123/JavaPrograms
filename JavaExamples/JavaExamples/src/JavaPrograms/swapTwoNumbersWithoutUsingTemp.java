package JavaPrograms;

public class swapTwoNumbersWithoutUsingTemp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int a=10;
		int b=20;
		int t;
		t=a;
		a=b;
		b=t;
		
		System.out.println("value of a is:"+a);
		System.out.println("value of a is:"+b);
		
		//using + operator
		int x=20;
		int y=30;
		x=x+y;
		y=x-y;
		x=x-y;
		
		System.out.println("after swap x value is:"+x);
		System.out.println("after swap x value is:"+y);
		
		//Using * operator
		int i=2;
		int j=5;
		i=i*j;
		j=i/j;
		i=i/j;
		System.out.println("after swap i value is:"+i);
		System.out.println("after swap j value is:"+j);
		
		
		//using XOR ^ --- it will return values in binary
		
		int m=22;
		int n=33;
		m=m^n;
		n=m^n;
		m=m^n;
		
		System.out.println("after swap m value is:"+m);
		System.out.println("after swap n value is:"+n);
		
				
		
		
		
		
		
		

	}

}
