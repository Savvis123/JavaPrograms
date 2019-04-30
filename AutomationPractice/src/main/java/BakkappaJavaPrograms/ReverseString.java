package BakkappaJavaPrograms;

public class ReverseString {

	public static void main(String[] args) {
	
		String s="Softwaretesting";
		String rev="";
		for(int i=s.length()-1;i>=0;i--)
		{
			rev=rev+s.charAt(i);
		}
		
		System.out.println(rev);
		
		StringBuffer sb=new StringBuffer(s);
		String rev1=sb.reverse().toString();
		System.out.println("string reverse using string buffer :"+rev1);
		

	}

}
