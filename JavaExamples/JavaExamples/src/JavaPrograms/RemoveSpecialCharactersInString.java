package JavaPrograms;

public class RemoveSpecialCharactersInString {

	public static void main(String[] args) {
		//use regular expressions[^a-zA-Z0-9]
		
		String s="@#$%mahesh1234RED D Y";
		s=s.replaceAll("[^a-zA-Z0-9]","");
		System.out.println("after removing special characters:"+s);
		

	}

}
