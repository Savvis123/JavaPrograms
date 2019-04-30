package JavaPrograms;

public class SumOfEachDigitInNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int n=245;
		int sum = 0;
		
		if(n==0)
		{
			System.out.println(sum);
		}
		else{
			
		while(n>0)
		{
			sum=sum+(n%10);
			n=n/10;
			
		
		}
		System.out.println("the sum of digits is :"+sum);
		
		}
	}

}
