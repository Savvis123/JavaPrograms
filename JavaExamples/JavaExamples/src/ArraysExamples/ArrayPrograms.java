package ArraysExamples;

public class ArrayPrograms {
	
	//Array is used to store similar data type values in a array variable

	public static void main(String[] args) {
		//creating int Array
		//double array
		//char array
		//boolean array
		//string array
		
		//disadvantages 
		//one dimessional array 
		//size is fixed so its called static array - To overcome this problem we use collections -ArrayList,HashTable--Dynamic Arrays
		//we can store only similar datatype values- To overcome this problem we use object Array
		int i[]=new int[5];
		i[0]=10;
		i[1]=20;
		i[2]=30;
		i[3]=40;
		i[4]=50;
		System.out.println("second value of Array is:"+i[1]);
		//ArrayIndexOutofBound Exception will come when we try to access not existing values
		//System.out.println("second value of Array is:"+i[5]);
		System.out.println("Size of the array is :"+i.length);
		
		//printing all values from array 
		for(int j=0;j<i.length;j++)
		{
			System.out.println(i[j]);
		}
		

	}

}
