package practiceForInterview;
public class printDuplicateElementsInArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int arr[]={1,2,3,4,2,3,4,5,6,7,8,6};
		
	
		for(int i=0;i<arr.length;i++)
		{
			for(int j=i+1;j<arr.length;j++)
			{
				if(arr[i]==arr[j])
				{
					System.out.println(arr[i]);
				}
				
			}
		}

	
		//unique elements
		int arr1[]={1,2,2,3,1,4,5,3,6,7,8};
		
				for(int i=0;i<arr1.length;i++){
					 boolean isDistinct = false; 
			            for(int j=i+1;j<arr1.length;j++){
			                if(arr[i] == arr[j]){
			                    isDistinct = true;
			                    break;
			                }
			            }
			            if(!isDistinct){
			                System.out.print(arr1[i]+" ");
			            }
			        }
	}

}
