package InterviewPrograms;

public class LargetAndSmallestNumbersInArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int numbers[]={-1,2,3,222,55,-87};
		
		int largest=numbers[0];
		int smallest=numbers[0];
		for(int i=1;i<numbers.length;i++)
		{
			if(numbers[i]>largest)
			{
				largest=numbers[i];
			}
			else if(numbers[i]<smallest)
			{
				smallest=numbers[i];
			}
		}

	System.out.println("elements from array is :"+numbers.toString());
	
	System.out.println("largets element from array is :"+largest);
	
	System.out.println("smallest element from array is :"+smallest);
	
	}

}
