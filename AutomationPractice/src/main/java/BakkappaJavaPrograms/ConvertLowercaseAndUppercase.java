package BakkappaJavaPrograms;

public class ConvertLowercaseAndUppercase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s="India";
		String str=null;
		char chArray[]=s.toCharArray();
		for(char ch:chArray)
		{
			if(ch=='i'|| ch =='I')
			{
				if(ch=='i')
				{
					str=""+ch;
					System.out.print(str.toUpperCase());
				}
				else if(ch=='I')
				{
					str=""+ch;
					System.out.print(str.toLowerCase());
				}
			}
			else
			{
				System.out.print(ch);
			}
			
			
		    
		}
		System.out.println();

	}

}
