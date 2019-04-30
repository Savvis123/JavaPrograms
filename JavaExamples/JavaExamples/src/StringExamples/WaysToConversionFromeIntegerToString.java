package StringExamples;

public class WaysToConversionFromeIntegerToString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int i=1234;
		
		//Using toString() method
 		String str1=Integer.toString(i);
		System.out.println("Firstway is :"+str1);
		
		
		//Using valueOf method of String
		String str2=String.valueOf(i);
		System.out.println("second way is :"+str2);
		
		//Using StringBuffer
		
		StringBuffer sbf=new StringBuffer();
		sbf.append(i);
		String str3=sbf.toString();
		System.out.println("Third way :"+str3);
		
		
		//Using StringBuilder
		StringBuilder sbr=new StringBuilder();
		sbr.append(i);
		String str4=sbr.toString();
		System.out.println("Third way :"+str4);
		
	
		
		
	}

}
