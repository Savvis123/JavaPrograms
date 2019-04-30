package StringExamples;

public class FromStringtoStringBufferandStringBuilder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String str="mahesh";
		
		StringBuilder sbr=new StringBuilder(str);
		sbr.append("reddy");
		System.out.println(sbr);
		
		StringBuffer sbf=new StringBuffer(str);
	    sbf.reverse();
		System.out.println(sbf);
		
		
		StringBuffer sbf1=new StringBuffer("sivaprasad");
		sbf1.replace(1, 4,"");
		System.out.println(sbf1);
		

	}

}
