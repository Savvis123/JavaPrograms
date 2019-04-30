package StringExamples;

public class StringSplitExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str = "GeeksforGeeksforStudents";
		String st[]=str.split("for");
		for(String s:st){
			System.out.println(s);
		}
		
		
		String strr = "geekss@for@geekss";
        String [] arrOfStr = strr.split("@", -2);
 
        for (String a : arrOfStr)
        {
            System.out.println(a);
         }
		
		
		
		
	}

}
