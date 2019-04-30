package BakkappaJavaPrograms;

import java.util.ArrayList;
import java.util.List;

import edu.emory.mathcs.backport.java.util.Collections;

public class ReverseIntAndStringArray {

	public static void main(String[] args) {
		
		int arr[]={10,20,30,40,50};
		
		List list =new ArrayList<Integer>();
		
		for(int i=0;i<arr.length;i++)
		{
			System.out.println(arr[i]);
			list.add(arr[i]);
			//System.out.println(arr[i]);
		}
	
		
		Collections.reverse(list);
		
		for(Object object : list)
		{
			System.out.println(object);
		}
		
		
		
	}

}
