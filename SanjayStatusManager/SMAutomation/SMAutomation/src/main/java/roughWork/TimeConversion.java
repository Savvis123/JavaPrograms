package roughWork;

public class TimeConversion {

	public static void main(String []args) {
		
		int time = 41251 ;
		  int minutes = (int) (time/ 1000)  / 60; 
		  System.out.println("minutes = "+ minutes);
		  int seconds = (int) (time/ 1000) % 60;
		  System.out.println("seconds = "+ seconds);
		  
		  String Totaltime = minutes+" mins "+seconds+" sec" ;
		  
		  System.out.println(Totaltime);
		
	}
	
	
}
