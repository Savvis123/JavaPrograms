package JavaPrograms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class UniqueElementFromArray {

	public static void main(String[] args) {
	
		int arr[]={1,2,2,3,1,4,5,3,6,7,8};
		
		for(int i=0;i<arr.length;i++){
			 boolean isDistinct = false; 
	            for(int j=i+1;j<arr.length;j++){
	                if(arr[i] == arr[j]){
	                    isDistinct = true;
	                    break;
	                }
	            }
	            if(!isDistinct){
	                System.out.print(arr[i]+" ");
	            }
	        }
		
		Set<Integer> gasNames = new HashSet<>();
		List<Integer> records = new ArrayList<>();
		
	    records.add(1);
		records.add(1);
		records.add(2);
		records.add(3);
		records.add(4);
		records.add(2);

		for(Integer record : records) {
		  gasNames.add(record);
		}
		
		System.out.println(gasNames);
		
	    }
		

	}


