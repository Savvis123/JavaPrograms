package BakkappaJavaPrograms;

public class RemovewhitespacesfromStringwithoutUsingTrim {

	public static void main(String[] args) {

		//1st way
		
		String str="software     tetsting    engineer   in      centurylink  from  three  years";
		String withoutspace=str.replaceAll("\\s","#");
		System.out.println(withoutspace);
		
		//second way 
		char chArr[]=str.toCharArray();
		StringBuffer sb=new StringBuffer();
		for(int i=0;i<chArr.length;i++)
		{
			if((chArr[i]!=' ') && (chArr[i]!='\t'))
			{
				sb.append(chArr[i]);
			}
		}
		
		System.out.println(sb);
		

	}

}
