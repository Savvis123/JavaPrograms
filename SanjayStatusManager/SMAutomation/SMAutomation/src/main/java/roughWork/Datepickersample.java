package roughWork;

import java.util.Calendar;
import java.util.TimeZone;


public class Datepickersample {

	@SuppressWarnings("unused")
	private static String today ;
	
	
	 private static String getCurrentDay (){
		 
	        //Create a Calendar Object
	        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());

	        //Get Current Day as a number
	        int todayInt = calendar.get(Calendar.DAY_OF_MONTH);
	        System.out.println("Today Int: " + todayInt +"\n");

	        //Integer to String Conversion
	        String todayStr = Integer.toString(todayInt);
	        System.out.println("Today Str: " + todayStr + "\n");

	        return todayStr;
	    }
	
	public static void main (String []args) {
		
		today = getCurrentDay() ;
		
	}
	
	
}
