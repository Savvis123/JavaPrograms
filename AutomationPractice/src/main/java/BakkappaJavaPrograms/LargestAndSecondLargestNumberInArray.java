package BakkappaJavaPrograms;

public class LargestAndSecondLargestNumberInArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]={1,2,3,4,5,8,6,9,7};
		
		int firstlarget=arr[0];
		int secondlarget=arr[0];
		for(int i=0;i<arr.length;i++)
		{
			if(arr[i]>firstlarget)
			{
				secondlarget=firstlarget;
				firstlarget=arr[i];
			}
			else if(arr[i]>secondlarget)
			{
				secondlarget=arr[i];
			}
			
			
		}
		
		System.out.println("first larget number is:"+firstlarget);
		System.out.println("second larget number is :"+secondlarget);

	}

}
