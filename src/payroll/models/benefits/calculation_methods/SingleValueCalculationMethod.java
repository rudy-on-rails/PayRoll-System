package payroll.models.benefits.calculation_methods;


public class SingleValueCalculationMethod implements BenefitCalculationMethod {
	
	@Override
	public double getCalculatedValue(double initialCalculationValue) {		
		return initialCalculationValue;
	}

}
