package payroll.models.benefits;

public class SingleValueCalculationMethod implements BenefitCalculationMethod {
	
	@Override
	public double getCalculatedValue(double initialCalculationValue) {		
		return initialCalculationValue;
	}

}
