
public class NullPointerExceptionExample {

	/*NullPointerException is a RuntimeException . Runtime exceptions are critical and cannot be caught at compile time.
	 *  They crash the program at run time if they are not handled properly. When a class is instantiated,
	 *   its object is stored in computer memory. The NullPointerExceptions occur when you try to use a reference
	 *    that points to no location in memory (null) as though it were referencing an object. These include:

    Calling the instance method of a null object.
    Accessing or modifying the field of a null object.
    Throwing null as if it were a Throwable value.
*/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Object obj = null;

		obj.toString();

	}

}
