package BakkappaJavaPrograms;

public class StringOperations {

	public static void main(String[] args) {
		String s="java interview questions ";
		String s1="programs";
		String concatstring=s+s1;
		System.out.println("concatinating string is:"+concatstring);
		
		String arr[]=s.split(" ");
		for(String str:arr)
		{
			System.out.println("using split"+str);
		}

	}

}
