package JavaPrograms;

public class StringReverse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String str="maheshreddy";
		String rev="";
		for(int i=str.length()-1;i>=0;i--)
		{
			rev=rev+str.charAt(i);
		}

	System.out.println("reverse of string is :"+rev);
	
	//using string Buffer
	
	StringBuffer sbf=new StringBuffer(str);
	System.out.println("reverse of string is :"+sbf.reverse());
	
	
	
	}

}
