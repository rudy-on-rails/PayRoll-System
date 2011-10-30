package tests;

import static org.junit.Assert.*;

import org.joda.time.LocalDate;
import org.junit.Before;
import org.junit.Test;

import payroll.models.EmployeeConcrete;
import payroll.models.benefits.implementations.ThirteenthSalary;

/**
 * @author  rudyseidinger
 */
public class ThirteenthSalaryTest {
	/**
	 * @uml.property  name="employeeConcrete"
	 * @uml.associationEnd  
	 */
	EmployeeConcrete employeeConcrete;
	
	@Before
	public void SetUp() throws Exception{
		employeeConcrete = new EmployeeConcrete();
	}
	
	@Test
	public void test_CalculateBenefitValue_shouldReturnProportionalValueCaseEmployeeHasLessThanAYearOnCompany() {
		LocalDate nineMonthsAgo = LocalDate.now().minusMonths(9);
		employeeConcrete.setHireDate(nineMonthsAgo);
		employeeConcrete.setPaycheckSalary(1200);
		ThirteenthSalary thirteenthSalary = new ThirteenthSalary();
		assertEquals(900, thirteenthSalary.calculateBenefitValue(new LocalDate(), employeeConcrete), 0);
	}
	
	@Test
	public void test_CalculateBenefitValue_shouldReturnFullSalaryCaseEmployeeHasOneYearOrMoreOnCompany() {
		LocalDate aYearAgo = LocalDate.now().minusYears(1);
		employeeConcrete.setHireDate(aYearAgo);
		employeeConcrete.setPaycheckSalary(1200);
		ThirteenthSalary thirteenthSalary = new ThirteenthSalary();
		assertEquals(1200, thirteenthSalary.calculateBenefitValue(new LocalDate(), employeeConcrete), 0);
	}

}
