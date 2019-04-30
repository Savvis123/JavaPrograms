package JavaPrograms;

public class WrapeerClassExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*Wrapper class in java provides the mechanism to convert primitive into object and object into primitive.

		Since J2SE 5.0, autoboxing and unboxing feature converts primitive into object and object into primitive 
		automatically. The automatic conversion of primitive into object is known as autoboxing and vice-versa unboxing.*/

	
	//Autoboxing --- primitive to object
    int a=20;
	
	Integer i=Integer.valueOf(a);
	
	System.out.println("value of i is :"+i);
	
	System.out.println(a);
	
	
	//Unboxing-----object to primitive
	Integer x=new Integer(3);
	int j=x.intValue();
	System.out.println("after unboxing j value is :"+j);
	
	}

}
