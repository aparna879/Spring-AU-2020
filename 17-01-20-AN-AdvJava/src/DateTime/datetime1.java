package DateTime;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class datetime1 {

	 String mydob ="07/08/1999";
	 String sdob  ="01/01/2002";
	 String mydobt = "08-7-1999 11:18:56 PM";
	 String sdobt = "01-1-2002 10:15:55 AM";
	 
	 static final String DATE_FORMAT = "dd-M-yyyy hh:mm:ss a";
	 
	 
	 public static void main(String args[]) throws Exception {
	 datetime1 dt = new datetime1();
	 long result = dt.task1(dt.mydob,dt.sdob);
	 System.out.println("Difference in nanoseconds is:"+ result+"\n");
	 
	 long result2 = dt.task2(dt.mydobt,dt.sdobt);
	 System.out.println("Difference in days is:"+ result2);
	 
	 }
	 
	 long task1(String dob1, String dob2)throws Exception {
		 
		 System.out.println("Task 1");
		 SimpleDateFormat sdf1 = new SimpleDateFormat("MM/dd/yyyy");
		 Date date1 = (Date) sdf1.parse(dob1);
	     System.out.println("My DOB: " + date1);
	     
		 SimpleDateFormat sdf2 = new SimpleDateFormat("MM/dd/yyyy");
		 Date date2 = (Date) sdf2.parse(dob2);
	     System.out.println("SIBLING DOB: " + date2);
	     
	     long MilliSec1 = date1.getTime(); 
	     long MilliSec2 = date2.getTime(); 
	   
	     TimeUnit time = TimeUnit.MILLISECONDS; 
	     
	     long sec1 = time.toNanos(MilliSec1);
	     long sec2 = time.toNanos(MilliSec2);
	     
	     long diff = Math.abs(sec1-sec2);
		 return diff;		 
	 }
	 
	 long task2(String dob1, String dob2) {

	    System.out.println("Task 2");
        LocalDateTime dt = LocalDateTime.parse(dob2, DateTimeFormatter.ofPattern(DATE_FORMAT));

        ZoneId indiaZoneId = ZoneId.of("Asia/Kolkata");
        
        ZonedDateTime indiaZonedDateTime = dt.atZone(indiaZoneId);
        //System.out.println("Date (India) : " + indiaZonedDateTime);
        
        ZoneId newYokZoneId = ZoneId.of("America/New_York");
       
        ZonedDateTime nyDateTime = indiaZonedDateTime.withZoneSameInstant(newYokZoneId);
        //System.out.println("Date (New York) : " + nyDateTime);
        
        DateTimeFormatter format = DateTimeFormatter.ofPattern(DATE_FORMAT);
        //System.out.println("Date (India) : " + format.format(indiaZonedDateTime));
        
        LocalDateTime date1 = LocalDateTime.parse(dob1, DateTimeFormatter.ofPattern(DATE_FORMAT));
        System.out.println("My Date (New York) : " + date1);
        
        LocalDateTime date21 = LocalDateTime.parse(format.format(indiaZonedDateTime), DateTimeFormatter.ofPattern(DATE_FORMAT));
        System.out.println("Sibling Date (India) : " + date21);
        
        LocalDateTime date2 = LocalDateTime.parse(format.format(nyDateTime), DateTimeFormatter.ofPattern(DATE_FORMAT));
        System.out.println("Sibling Date (New York) : " + date2);
        
        long diff = ChronoUnit.DAYS.between(date1,date2);
        return diff;
	 }
}

