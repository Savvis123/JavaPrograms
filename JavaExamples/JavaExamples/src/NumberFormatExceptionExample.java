
public class NumberFormatExceptionExample {
	
	/*Java exception FAQ: What is a Java NumberFormatException?

Answer: A Java NumberFormatException usually occurs when you try to do something like convert 
a String to a numeric value,
 like an int, float, double, long, etc.*/

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s="mahesh";
		int i =Integer.parseInt(s);
		System.out.println(i);
	}

}
