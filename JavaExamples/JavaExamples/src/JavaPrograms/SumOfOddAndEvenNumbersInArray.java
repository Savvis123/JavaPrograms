package JavaPrograms;

public class SumOfOddAndEvenNumbersInArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int arr[]={1,2,3,4,5,6,7,8,9,10};
		
		int sumOdd=0;
		int sumEven=0;
		
		for (int i=0;i<arr.length;i++)
		{
		
			if(arr[i]%2==0)
			{
				sumEven=sumEven+arr[i];
		
			}
			else
			{
				sumOdd=sumOdd+arr[i];
				
			}
		}

	
	}

}
