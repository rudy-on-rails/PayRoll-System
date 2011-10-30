package payroll.models.benefits;

public interface BenefitCalculationMethod {	
	double getCalculatedValue(double initialCalculationValue);
}
