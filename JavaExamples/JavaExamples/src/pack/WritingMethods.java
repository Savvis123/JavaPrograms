package pack;

public class WritingMethods {
	
	public void test()
	{
		System.out.println("this is not returning any value");
	}
	
	public int sumofTwonumbers()
	{
		System.out.println("returning int value");
		int a=10;
		int b=20;
		int c =a+b;
		return c;
	}
	
	public String  message()
	{
	System.out.println("returning string value");
	
	String s="selenium";
	return s;
	}
	
	public int devision(int i,int j)
	
	{
		System.out.println("taking input and returning output");
		int d=i/j;
		return d;
		
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WritingMethods wm=new WritingMethods();
		wm.sumofTwonumbers();
		wm.message();
		wm.devision(20, 2);
		wm.test();
		

	}

}
