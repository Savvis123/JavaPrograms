package JavaPrograms;

public class CheckPrimeNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int n=13;
		boolean isPrime=true;
		
		for(int i=2;i<=n/2;i++)
		{
			if(n%i==0)
			{
				isPrime=false;
				break;
			}
		}

		if(isPrime)
		{
			System.out.println("given number is prime");
		}
		else
		{
			System.out.println("given number is not prime");
		}
		
	}

}
