package pe.com.intralot.loto.utils;

import java.text.SimpleDateFormat;
import java.util.*;

/**<p> NAME:    DateAPI.java         
 * </p>
 * <p> VERSION LOG
 * <pre>
 * VER   BY          DATE        COMMENT
 * 001   c_achata    25/11/2016  First comment
 * </pre>
 * </p>
 */

public class DateAPI extends GregorianCalendar {
	
	private static final long serialVersionUID = -3347913640685927860L;

	public DateAPI(long date) {
		this.setTimeInMillis(date);
	}
	
	public DateAPI(String input, String formatString) 
	{
		Date calDate = null;
		try {
			SimpleDateFormat format = new SimpleDateFormat(formatString);
			calDate = format.parse(input);			
		} catch (Exception e) {
			calDate = null;
		}
        this.setTime( calDate );
	}
	
	public DateAPI() {
		getInstance();
	}

	
	public boolean isAfterDate(DateAPI day) {
		boolean isAfter = false;
		try {
			isAfter = this.after(day);
		} catch (Exception e) {
			isAfter = false;
		}
		return isAfter;
	}
	
	public DateAPI trunc() {
		
		this.set(Calendar.HOUR_OF_DAY, 0);
		this.set(Calendar.MINUTE, 0);
		this.set(Calendar.SECOND, 0);
		this.set(Calendar.MILLISECOND, 0);
		 
        return this;
	}
		
	public static String getToday(String formatString) {
		String output = null;
		Calendar cal = getInstance();
		SimpleDateFormat dateFormat = new SimpleDateFormat(formatString);
		output = dateFormat.format( cal.getTime() );
		return output;
	}
		
	public static boolean isValidDate(String input, String formatString) 
	throws Exception
	{	
		boolean isValid = false;
		try {
	        SimpleDateFormat format = new SimpleDateFormat(formatString);
			Date calDate = format.parse(input);
			Calendar cal = new GregorianCalendar();
			cal.setTime( calDate );
			isValid = true;
		} catch (Exception e) {
			isValid = false;
		}
		return isValid;
	}

	
	public String getDate(String format) {
		
		String output = "";
		
	    if (this == null) return output;
	    if (this.getTimeInMillis()==0) return output;
	    
	    Locale locale = new Locale("es");
		SimpleDateFormat dateFormat = new SimpleDateFormat(format, locale);
		output = dateFormat.format( ((Calendar)this).getTime() );
		Locale.setDefault(Locale.ENGLISH);
		return output;
		
	}	
	
	public String getDateEnglish(String format) {
		
		String output = "";
		
	    if (this == null) return output;
	    if (this.getTimeInMillis()==0) return output;
	    
		Locale.setDefault(Locale.ENGLISH);
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		output = dateFormat.format( ((Calendar)this).getTime() );
		return output;
		
	}

	public long getTimeLong() {
		return this.getTimeInMillis();
	}	

	public static long getNow() {
    	return Calendar.getInstance().getTime().getTime() ;
	}	
	
	public static long getNextDateTime (int calendarType, int count)  {
		// Calendar.DATE
		// Calendar.HOUR
		Calendar cal = getInstance();
		cal.add(calendarType, count);
		return cal.getTimeInMillis();
	}
	
	
	public String toString() {
		return  getDate("dd/MM/yyyy HH:mm:ss");
	}
	
	public static String formatBuyDate(String buyDate) {
		if(buyDate == null) {
			return buyDate;
		}
		
		String date = "";
		String time = "";
		String dateTime = buyDate.trim().replaceAll("-", "/").toLowerCase();
		Integer separation = dateTime.indexOf(" ");
		
		if(separation > 0) {
			date = dateTime.substring(0, separation).trim();
			time = " | ".concat(dateTime.substring(separation).trim());
		}else {
			date = dateTime;
		}
		
		String[] splits = date.split("/");
		if(splits.length > 1 && splits[0].length()==4) {
			date = splits[2]+"/"+splits[1]+"/"+splits[0];
		}

		return date.concat(time);
	}
	
	public static Date parseToDate(String dateStr) {
		try {
			dateStr = dateStr.trim().replaceAll("-", "/");

			SimpleDateFormat sdf;

			if (dateStr.matches(".*\\d{2}/\\d{2}/\\d{4}.*[AaPp][Mm]$")) {
				sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss a");
			} else if (dateStr.contains(" ")) {
				sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			} else {
				sdf = new SimpleDateFormat("dd/MM/yyyy");
			}

			return sdf.parse(dateStr);
		} catch (Exception e) {
			return new Date(0);
		}
	}
	
	public static String DateToformatBuyDate(Object value) {
	    if (value == null || !(value instanceof String)) {
	        return null;
	    }

	    try {
	        SimpleDateFormat inputFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	        Date date = inputFormat.parse((String) value);

	        SimpleDateFormat outputFormat = new SimpleDateFormat("dd/MM/yyyy | hh:mm:ss a");
	        return outputFormat.format(date).toLowerCase();

	    } catch (Exception e) {
	        return value.toString();
	    }
	}
}
