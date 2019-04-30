package FileExamples;

public class EscapeCharacters {
	
	static String inputString ="mahesh$";

	   
	    
	

	public static void main(String[] args) {
		
		 final String[] metaCharacters = {"\\","^","$","{","}","[","]","(",")",".","*","+","?","|","<",">","-","&"};
		    String outputString="";
		    for (int i = 0 ; i < metaCharacters.length ; i++){
		        if(inputString.contains(metaCharacters[i])){
		            outputString = inputString.replace(metaCharacters[i],"\\"+metaCharacters[i]);
		            inputString = outputString;
		        }
		    }
		    
		    System.out.println(inputString);
	}

}
