package ArraysExamples;

public class PrintPairsEqualToSomeNumberInArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int arr[]={2,3,4,5,6,1,7,0};
		//int sum=7;
		int count =0;
		for(int i=0;i<arr.length;i++)
		{
			for(int j=i+1;j<arr.length;j++)
			{
				if(arr[i]+arr[j]==10)
				{
					count++;

					System.out.println(arr[i]+"  , "+arr[j]);
					System.out.println();
				}

			}
		}
		
		
		
		System.out.println(count);

	}

}
