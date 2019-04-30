package JavaPrograms;

public class FirstNonRepeatedCharacterInString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String str="maheshm";
		char st = 0;
		int count =0;
		int i,j;
		
		for(i=0;i<str.length()-1;i++)
		{
			for(j=i+1;j<str.length()-1;j++)
			{
				if(str.charAt(i)!=str.charAt(j))
				{
					count++;
					
				}
				
				if (count==1)
				{
					break;
				}
				count=0;
			}
			
			 
		}
		
		System.out.println(str.charAt(i)); 
	}

}
