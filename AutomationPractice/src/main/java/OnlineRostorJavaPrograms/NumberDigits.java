package OnlineRostorJavaPrograms;

public class NumberDigits {
	public static void main(String args[])
	{
		int count=0;
		int n=225546;
		while(n!=0)
		{
			n=n/10;
			count++;
		}
		
		System.out.println(count);
	}

}
