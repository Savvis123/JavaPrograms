package BakkappaJavaPrograms;

import java.util.Arrays;

public class ArraysAscedingAndDescendingOrder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int arr[]={1,2,3,4,5,6,9,7,0};
		Arrays.sort(arr);
		
		for(int i=0;i<arr.length;i++)
		{
			System.out.println(arr[i]);
		}
		System.out.println("=======================");
		for(int j=arr.length-1;j>=0;j--)
		{
			System.out.println(arr[j]);
		}

	}

}
