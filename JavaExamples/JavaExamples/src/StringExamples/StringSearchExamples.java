package StringExamples;

public class StringSearchExamples {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String str="mahesh is a good boy";
		int firstIndex=str.indexOf("is");
        System.out.println("matching string is :"+firstIndex);
        
        boolean starwithtext=str.startsWith("mahesh");
        System.out.println("result for startwith funtion :"+starwithtext);
        
        boolean endwithtext=str.endsWith("boy");
        System.out.println("result for endwith funtion :"+endwithtext);
        
        
     // Index of the first occurrence of specified char
        // after the specified index if found.
        
        int firstspecifiedindex=str.indexOf('s',10);
        
        System.out.println("get the value using firstspecifiedindex :"+firstspecifiedindex);
        
        
        //get the ASCII value of character
        
        int asciival=str.charAt(5);
        System.out.println("ASCII value of character :"+asciival);
        

       // Returns index of last occurrence specified character.
        int lastIndex = str.lastIndexOf('s');
        System.out.println("Last occurrence of char 's' is" +
                           " found at : " + lastIndex);
        
        
	}

}
