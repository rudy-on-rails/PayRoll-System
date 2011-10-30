package payroll.models;

import org.joda.time.LocalDate;


/**
 * @author  rudyseidinger
 */
public class EmployeeConcrete implements Employee {
	/**
	 * @uml.property  name="paycheckSalary"
	 */
	private double PaycheckSalary;
	private LocalDate hireDate;
	
	@Override
	public double getBenefitsAmount() {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * @param paycheckSalary
	 * @uml.property  name="paycheckSalary"
	 */
	public void setPaycheckSalary(double paycheckSalary) {
		PaycheckSalary = paycheckSalary;
	}

	/**
	 * @param hireDate
	 * @uml.property  name="hireDate"
	 */
	public void setHireDate(LocalDate hireDate) {
		this.hireDate = hireDate;
	}

	/**
	 * @return
	 * @uml.property  name="paycheckSalary"
	 */
	@Override
	public double getPaycheckSalary() {
		return PaycheckSalary;
	}

	@Override
	public double CalculateSalaryWithBenefits() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public LocalDate getEmployeeHiredDate() {
		return hireDate;
	}
}
