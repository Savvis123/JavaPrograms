package JavaPrograms;

public class DuplicateElementsFromArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
int arr[]={1,2,2,3,1,4,5,3,6,7,8};
		
		for(int i=0;i<arr.length;i++){
			 boolean isDistinct = true; 
	            for(int j=i+1;j<arr.length;j++){
	                if(arr[i] == arr[j]){
	                    isDistinct = false;
	                    break;
	                }
	            }
	            if(!isDistinct){
	                System.out.print(arr[i]+" ");
	            }
	        }

	}

}
