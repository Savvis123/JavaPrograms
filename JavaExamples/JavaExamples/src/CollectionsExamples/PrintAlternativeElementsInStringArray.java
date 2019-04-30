package CollectionsExamples;

public class PrintAlternativeElementsInStringArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String str="Mahesh";
		char[] ch=str.toCharArray();
		for(int i=0;i<ch.length;i=i+2)
		{
			System.out.println(ch[i]);
		}
		
		
		
		String st="good";
		for(int j=0;j<st.length();j=j+2)
		{
			System.out.println(j);
		}
	}

}
