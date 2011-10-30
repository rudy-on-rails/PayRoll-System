package tests;

import static org.junit.Assert.*;

import org.joda.time.LocalDate;
import org.junit.Test;

import payroll.helpers.DateHelper;

public class BenefitDateHelperTest {

	@Test
	public void test_IsOnSameYearAndMonth_shouldBeTrueForSameYearAndMonth() {		
		assertTrue(DateHelper.IsOnSameMonth(new LocalDate(), new LocalDate()));
	}

	@Test
	public void testNumberOfYears_aYearAgoShouldReturnOne() {
		LocalDate yearAgo = LocalDate.now().minusYears(1);		
		assertEquals(1, DateHelper.NumberOfYears(yearAgo, new LocalDate()), 0);
	}

	@Test
	public void testIsOnSameMonth_ShouldReturnTrueForSameMonth() {
		assertTrue(DateHelper.IsOnSameMonth(new LocalDate(), new LocalDate()));
	}
	
	@Test
	public void testIsOnSameMonth_ShouldReturnFalseForDifferentMonths() {
		LocalDate yearAgo = LocalDate.now().minusYears(1);
		assertTrue(DateHelper.IsOnSameMonth(yearAgo, new LocalDate()));
	}

}
