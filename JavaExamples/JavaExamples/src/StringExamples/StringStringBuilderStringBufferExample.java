package StringExamples;

public class StringStringBuilderStringBufferExample {
	
	
	//String is immutable 
	
	//StringBuffer is synchronized and will be used when we need to perform lot of operation on string for single thread
	//performance is slow
	
	
	//StringBuilder is unsynchronized and will be used when we need to perfrom lot of operations on string for multiple threads
	//performance is fast
	public static void concat1(String s1)
	    {
	        s1 = s1 + "forgeeks";
	    }
	 
	 public static void concat2(StringBuilder s2)
	    {
	      s2.append("forgeeks");
	    }
	 
	 public static void concat3(StringBuffer s3)
	    {
	         s3.append("forgeeks");
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s1="Geeks";
		concat1(s1);
		System.out.println(s1);
		
		StringBuilder s2=new StringBuilder("mahesh");
		concat2(s2);
	    System.out.println(s2);
		
		StringBuffer s3=new StringBuffer("MaheshReddy");
		concat3(s3);
		System.out.println(s3);
		
	}

}
