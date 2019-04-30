package BakkappaJavaPrograms;

public class PrintAlphabetsAndNumericsFromString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s="Software12 Testing34 Engineer45";
		String alphabets=" ";
		String numbers=" ";
		for(int i=0;i<s.length();i++)
		{
			char ch=s.charAt(i);
			
			if(Character.isDigit(ch))
			{
				numbers = numbers+ch;
			}
			else
			{
				alphabets=alphabets+ch;
			}
			
			
			
		}
		
		System.out.println("Alphabets from string "+alphabets);
		System.out.println("Numbers from String: "+numbers);
		

	}

}
