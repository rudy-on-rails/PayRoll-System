package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import payroll.models.EmployeeConcrete;
import payroll.models.benefits.implementations.HealthCarePlan;

/**
 * @author  rudyseidinger
 */
public class HealthCarePlanTest {
	
	private EmployeeConcrete employee;
	
	@Before
	public void setUp() throws Exception {
		employee = new EmployeeConcrete();
	}

	@Test
	public void test_CalculateBenefitValue_shouldReturnTwoHundredMinusFourPercentOfEmploeeSalaryCaseFourPercentIsLessThanOneHundredFifty() {
		employee.setPaycheckSalary(2000);
		HealthCarePlan healthCarePlan = new HealthCarePlan();
		assertEquals(120, healthCarePlan.calculateBenefitValue(null, employee),0);
	}

	@Test
	public void test_CalculateBenefitValue_shouldReturnTwoHundredMinusOneHundredFiftyIfFourPercentOfEmployeeSalaryIsMoreThanOneHundredFifty() {
		employee.setPaycheckSalary(8000);
		HealthCarePlan healthCarePlan = new HealthCarePlan();
		assertEquals(50, healthCarePlan.calculateBenefitValue(null, employee),0);
	}
}
