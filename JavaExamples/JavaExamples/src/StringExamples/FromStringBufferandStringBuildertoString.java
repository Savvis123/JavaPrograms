package StringExamples;

public class FromStringBufferandStringBuildertoString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		StringBuilder sbr=new StringBuilder("Geeks");
		String str1=sbr.toString();
		System.out.println("StringBuilder to String value is: "+str1);
		System.out.println("change string value is :"+sbr.append("Test"));
		
		StringBuffer sbf=new StringBuffer("Geeks");
		String str2=sbf.toString();
		System.out.println("StringBuffer to String value is:"+str2);
		System.out.println("change string value is :"+sbf.append("Test"));	
	

	}

}
