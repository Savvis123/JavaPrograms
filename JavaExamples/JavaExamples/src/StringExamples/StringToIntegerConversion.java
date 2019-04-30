package StringExamples;

public class StringToIntegerConversion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String str="20";
		int i=Integer.parseInt(str);
		
		System.out.println("Conversion using parseInt:"+i);

		int j=Integer.valueOf(str);
		System.out.println("Conversion using value of method :"+j);
		
	}

}
