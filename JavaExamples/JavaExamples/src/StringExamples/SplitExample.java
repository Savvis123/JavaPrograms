package StringExamples;

public class SplitExample {

	public static void main(String[] args) {
		String str="java string split method by mahesh"; 
		String[] string=str.split("\\s");
		
		for(String word : string)
		{
			System.out.println(word);
		}
		
		String s1="welcome to split world";
		System.out.println("returning words:");  
		for(String w:s1.split("\\s",1)){  
		System.out.println(w);  
		}  
		
		System.out.println("returning words:");  
		for(String w:s1.split("\\s",2)){  
		System.out.println(w);  
		}

	  
	}

}
