package payroll.models.benefits.implementations;

import org.joda.time.LocalDate;

import payroll.helpers.DateHelper;
import payroll.models.Employee;
import payroll.models.benefits.Benefit;
import payroll.models.benefits.calculation_methods.BenefitCalculationMethod;
import payroll.models.benefits.calculation_methods.MonthsProportionalCalculationMethod;
import payroll.models.benefits.calculation_methods.SingleValueCalculationMethod;

/**
 * @author  rudyseidinger
 */
public class ThirteenthSalary implements Benefit {

	private Employee employee;
	private LocalDate calculationDate;
	
	@Override
	public double calculateBenefitValue(LocalDate calculationDate, Employee employee) {
		this.employee = employee;
		this.calculationDate = calculationDate;
		BenefitCalculationMethod calculationMethod = this.getBenefitCalculationMethod();		
		return calculationMethod.getCalculatedValue(employee.getPaycheckSalary());
	}

	@Override
	public BenefitCalculationMethod getBenefitCalculationMethod() {
		if (DateHelper.NumberOfYears(employee.getEmployeeHiredDate(), calculationDate) >= 1)
			return new SingleValueCalculationMethod();
		else
			return new MonthsProportionalCalculationMethod(DateHelper.NumberOfMonths(employee.getEmployeeHiredDate(), calculationDate));
	}	
}
