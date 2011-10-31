package payroll.models.benefits.calculation_methods;


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
		if (salaryPercentageIsEqualOrGreaterThanMaximumValue())
			return initialCalculationValue - maximumValueToReach;
		else
			return initialCalculationValue - applyPercentageEmployeeSalary();
	}

	private boolean salaryPercentageIsEqualOrGreaterThanMaximumValue() {
		return applyPercentageEmployeeSalary() >= maximumValueToReach;
	}

	private double applyPercentageEmployeeSalary() {
		return (employeeSalary * percentualToApply) / 100;
	}
}
