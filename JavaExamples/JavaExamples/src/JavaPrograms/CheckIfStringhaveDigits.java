package JavaPrograms;

public class CheckIfStringhaveDigits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String str="mahesh123456jgjg";
		
		for(int i=0;i<str.length()-1;i++)
		{
			char ch=str.charAt(i);
			if(Character.isDigit(ch))
			{
				System.out.print(ch);
			}
		}
		
		

	}

}
