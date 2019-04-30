package JavaPrograms;

public class PerfectNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int number =28;
		int temp=0;
		for(int i=1;i<=number/2;i++)
		{
			if(number%i==0)
			{
				temp=temp+i;
			}
		}
		
		System.out.println("temp val is:"+temp);

		if(temp==number)
		{
			System.out.println("the given number is perfect number");
		}
		else
		{
			System.out.println("not a perfect number");
		}
	}

}
