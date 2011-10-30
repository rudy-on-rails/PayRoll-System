package payroll.models.benefits;

import org.joda.time.LocalDate;
import payroll.models.Employee;



public interface Benefit  {
	double calculateBenefitValue(LocalDate calculationDate, Employee employee);
	BenefitCalculationMethod getBenefitCalculationMethod();	
}
