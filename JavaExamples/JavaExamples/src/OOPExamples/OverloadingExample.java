package OOPExamples;

public class OverloadingExample {
	int sum=0;
	
	
	
	public void sum(int a,int b)
	{
		sum=a+b;
		System.out.println("sum of two numbers is :"+sum);
	}
	
	public void sum(int a,int b,int c)
	{
		sum=a+b+c;
		System.out.println("sum of two numbers is :"+sum);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		OverloadingExample overloadingExample =new OverloadingExample();
		overloadingExample.sum(10, 20);
		overloadingExample.sum(10, 20,30);
	}

}
