package payroll.models.benefits;

import org.joda.time.LocalDate;
import payroll.models.Employee;
import payroll.models.benefits.calculation_methods.BenefitCalculationMethod;



public interface Benefit  {
	double calculateBenefitValue(LocalDate calculationDate, Employee employee);
	BenefitCalculationMethod getBenefitCalculationMethod();	
}
