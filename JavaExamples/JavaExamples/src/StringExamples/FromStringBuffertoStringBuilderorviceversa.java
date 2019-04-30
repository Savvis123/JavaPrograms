package StringExamples;

public class FromStringBuffertoStringBuilderorviceversa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//String Buffer to StringBuilder
		StringBuffer sbf=new StringBuffer("Geeks");
		String str=sbf.toString();
		System.out.println("StringBuffer to String is :"+str);
		
		StringBuilder sbr=new StringBuilder(str);
		System.out.println("StringBuffer to StringBuilder value is :"+sbr);
		
		
		//StringBuilder to StringBuffer
		
		StringBuilder sbr1=new StringBuilder("mahesh");
		String s =sbr1.toString();
		System.out.println("String builder to string value is :"+s);
		
		StringBuffer sbf1=new StringBuffer(s);
		System.out.println("StringBuilder to StringBuffer value is: "+sbf1);
		
		

	}

}
