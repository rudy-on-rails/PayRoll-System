package payroll.models;

import org.joda.time.LocalDate;

public interface Employee {	
	double getBenefitsAmount();
	double getPaycheckSalary();
	double CalculateSalaryWithBenefits();
	LocalDate getEmployeeHiredDate();
}
