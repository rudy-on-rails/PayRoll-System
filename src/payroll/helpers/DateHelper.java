package payroll.helpers;

import org.joda.time.LocalDate;
import org.joda.time.Period;

public final class DateHelper {
	public static LocalDate Now(){		
		return new LocalDate();
	}
	
	public static boolean IsOnSameYearAndMonth(LocalDate firstCalendar, LocalDate secondCalendar){		
		return IsOnSameMonth(firstCalendar, secondCalendar) && firstCalendar.getYear() == secondCalendar.getYear();
	}
	
	public static double NumberOfYears(LocalDate firstDate, LocalDate secondDate){		
		Period period = new Period(firstDate, secondDate);
		return period.getYears();
	}
	
	public static boolean IsOnSameMonth(LocalDate firstCalendar,
			LocalDate secondCalendar) {
		return firstCalendar.getMonthOfYear() == secondCalendar.getMonthOfYear();
	}
	
	public static int NumberOfMonths(LocalDate firstDate,
			LocalDate secondDate) {		
		Period period = new Period(firstDate, secondDate);
		return period.getMonths();		
	}
}
