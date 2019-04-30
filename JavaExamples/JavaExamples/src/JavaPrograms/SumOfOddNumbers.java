package JavaPrograms;

public class SumOfOddNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int arr[]={2,3,4,5,6,7,8,9,1};
		
		int sum=0;
		int sum1=0;

		for(int i=0;i<arr.length;i=i+2)
		{
			sum=sum+arr[i];
			
		}
		
		System.out.println(sum);
		
		for(int j=1;j<arr.length;j=j+2){
			
			sum1=sum1+arr[j];
		}
		
		System.out.println(sum1);
	}

}
