package payroll.models.benefits.calculation_methods;

public interface BenefitCalculationMethod {	
	double getCalculatedValue(double initialCalculationValue);
}
