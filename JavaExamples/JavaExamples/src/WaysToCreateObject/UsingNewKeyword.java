package WaysToCreateObject;

public class UsingNewKeyword {
	
	
/*we can create object in 5 ways in java
 * 1.Using New keyword
 * 2.Using newInstance
 * 3.Cloning existing object
 * 4.Using deserialization :Whenever we serialize and then deserialize an object JVM creates a separate object
 * for us. In deserialization, JVM doesn’t use any constructor to create the object.
To deserialize an object we need to implement the Serializable interface in our class.
 * 5.Using newInstance() method of Constructor class
 * Similar to the newInstance() method of Class class, There is one newInstance() method 
 * in the java.lang.reflect.Constructor class which we can use to create objects. We can also call a parameterized 
 * constructor,and private constructor by using this newInstance() method.
 * 
 
 
 * */
	String s="my name is mahesh";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	
		
		UsingNewKeyword obj=  new UsingNewKeyword();
		System.err.println(obj.s);

	}

}
