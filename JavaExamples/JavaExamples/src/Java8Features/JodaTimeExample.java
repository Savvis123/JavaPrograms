package Java8Features;
import java.time.*;

public class JodaTimeExample {
	
	/*Joda-time provides better classes to handle date and time
	 * Date API ---java.util
            java.sql

to format date we need to use java.text*;

not thread safe

in Java 1.8 special package is introduced that is java.time */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LocalDate today=LocalDate.now();
		System.out.println(today);
		
		LocalDate ldate=LocalDate.of(1987, Month.FEBRUARY ,28);
		System.out.println(ldate);
		
		LocalTime ltime=LocalTime.of(12, 23, 12);
		System.out.println(ltime);
		
		
		LocalTime time=LocalTime.now();
		System.out.println(time);
		
		LocalTime lt=LocalTime.now(ZoneId.of("GMT"));
		System.out.println("ZoneId time is:"+lt);
		
		Instant ins=Instant.now();
		System.out.println(ins);
		
		for(String s:ZoneId.getAvailableZoneIds())
		{
			System.out.println("Time Zones are :"+s);
		}
		

	}

}
