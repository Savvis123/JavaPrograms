package BakkappaJavaPrograms;

public class FindMaxAndMinValuesFromArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int arr[]={10,20,30,40,50,2};
		
		int max=arr[0];
		int min=arr[0];
		
		for(int i=0;i<arr.length;i++)
		{
			if(max<arr[i])
			{
				max =arr[i];
			}
			
		}

		
		System.out.println("max value is :"+max);
		
		
		for(int i=0;i<arr.length;i++)
		{
			if(min>arr[i])
			{
				min =arr[i];
			}
			
		}
		
		System.out.println("min value is :"+min);
	}

}
