package InterviewPrograms;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class ArraySortPrograms {
	
	//using sort method for Ascending

	public static void main(String[] args) {
		  int[] arr = {13, 7, 6, 45, 21, 9, 2, 100};
		  Arrays.sort(arr);
		  System.out.println("sort array is :"+Arrays.toString(arr));
		  
    //Using sort method for descending
		  Integer[] arr1 = {13, 7, 6, 45, 21, 9, 2, 100};
		  
	        // Sorts arr[] in descending order
	        Arrays.sort(arr1,Collections.reverseOrder());
	 
	        System.out.printf("descending order is :"+ Arrays.toString(arr1));
	        
	        
	 //without using sort method
	        System.out.println("========without using sort method================");
	        
	   
	        int a[]={2,5,3,4,6,1};
	        
	        int length=a.length;
	        System.out.println("array lenght is:"+length);
	       
	            for(int i=0;i<a.length-1;i++)
	            {
	            for(int j=0;j<a.length-1;j++)
	            {
	                if(a[j]>a[j+1])
	                {
	                int temp=a[j+1];
	                    a[j+1]=a[j];
	                    a[j]=temp;
	                }
	            }
	           }
	       
	       for(int i=0;i<a.length;i++)
	        {
	            System.out.println("array is"+a[i]);

	         }

	}

}
