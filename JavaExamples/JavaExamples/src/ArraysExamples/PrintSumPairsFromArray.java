package ArraysExamples;

public class PrintSumPairsFromArray {

	public static void main(String[] args) {
		
		int sample[]={1,2,3,4,5};
		int simple[]={4,5,6,7,8};
		
		for (int i=0;i<sample.length;i++)
		{
			int first=sample[i];
			
			for(int j=0;j<simple.length;j++)
			{
				int second=simple[j];
				if(first+second==7)
				{
					System.out.printf("(%d,%d) %n",first,second);
				}
				
			}
			
		}
	}

}
