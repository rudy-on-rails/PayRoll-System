package payroll.models.benefits.implementations;

import org.joda.time.LocalDate;

import payroll.models.Employee;
import payroll.models.benefits.Benefit;
import payroll.models.benefits.calculation_methods.BenefitCalculationMethod;
import payroll.models.benefits.calculation_methods.PercentualOfSalaryWithMaximumCalculationMethod;

public class HealthCarePlan implements Benefit {
	private double employeeSalary;
		
	@Override
	public double calculateBenefitValue(LocalDate calculationDate,
			Employee employee) {
		this.employeeSalary = employee.getPaycheckSalary();
		return getBenefitCalculationMethod().getCalculatedValue(200);		
	}

	@Override
	public BenefitCalculationMethod getBenefitCalculationMethod() {		
		return new PercentualOfSalaryWithMaximumCalculationMethod(4, 150, employeeSalary);		
	}	

}
