package tests;

import static org.junit.Assert.*;

import org.joda.time.LocalDate;
import org.junit.Before;
import org.junit.Test;

import payroll.models.EmployeeConcrete;
import payroll.models.benefits.implementations.AdditionalSalary;

/**
 * @author  rudyseidinger
 */
public class AdditionalSalaryTest {
	/**
	 * @uml.property  name="employee"
	 * @uml.associationEnd  
	 */
	private EmployeeConcrete employee;	
		
	@Before
	public void setUp() throws Exception {
		employee = new EmployeeConcrete();		
	}

	@Test
	public void test_calculateBenefitValue_EmployeeWithLessThanAnYearReceivesNothing() {
		LocalDate now = new LocalDate();
		employee.setHireDate(now);
		employee.setPaycheckSalary(1000);
		AdditionalSalary additionalSalary = new AdditionalSalary();
		assertEquals(0, additionalSalary.calculateBenefitValue(now, employee),0);
	}
	
	@Test
	public void test_calculateBenefitValue_EmployeeWithOnYearOrMoreOnCompanyReceivesHisSalary() {
		LocalDate now = new LocalDate();
		LocalDate yearAgo = LocalDate.now().minusYears(1);
		employee.setHireDate(yearAgo);
		employee.setPaycheckSalary(1000);
		AdditionalSalary additionalSalary = new AdditionalSalary();
		assertEquals(1000, additionalSalary.calculateBenefitValue(now, employee),0);
	}

}
