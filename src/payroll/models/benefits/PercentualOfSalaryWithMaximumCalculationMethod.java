package payroll.models.benefits;

public class PercentualOfSalaryWithMaximumCalculationMethod implements
		BenefitCalculationMethod {
	private double percentualToApply;
	private double maximumValueToReach;
	private double employeeSalary;

	public PercentualOfSalaryWithMaximumCalculationMethod(
			double percentualToApply, double maximumValueToReach, double employeeSalary) {
		this.percentualToApply = percentualToApply;
		this.maximumValueToReach = maximumValueToReach;
		this.employeeSalary = employeeSalary;
	}

	@Override
	public double getCalculatedValue(double initialCalculationValue) {
		if (applyPercentageEmployeeSalary(employeeSalary) > maximumValueToReach)
			return initialCalculationValue - maximumValueToReach;
		else
			return initialCalculationValue - (employeeSalary * percentualToApply) / 100;
	}

	private double applyPercentageEmployeeSalary(double employeeSalary) {
		return (employeeSalary * percentualToApply) / 100;
	}

}
