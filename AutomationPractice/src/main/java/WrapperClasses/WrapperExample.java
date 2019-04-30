package WrapperClasses;

public class WrapperExample {
    //wrapper classes are used to convert the primitive data into objects
	public static void main(String[] args) {
		
		//boxing ---convert the primitive data into objects 
		int a=10;
		Integer in =new Integer(a);
		
		long l=10;
		Long lo=new Long(l);
		
		//autoboxing---java automatically wraps primitive data into corresponding wrapper object.
		
		int x=10;
		Integer y=x;
		
		//unboxing----unwrapping wrapper object into corresponding primitive data.
		
		Byte B=new Byte((byte)10);
		
		byte b=B.byteValue();
		
		
		Integer I =new Integer((int)10);
		int i=I.intValue();
		
		//autounboxing-----Java implicitly converts wrapper object to corresponding primitive data if you assign wrapper object to primitive type variable.
		
		Byte by=new Byte((byte)10);
		byte byt=by;
		
		 
	}

}
