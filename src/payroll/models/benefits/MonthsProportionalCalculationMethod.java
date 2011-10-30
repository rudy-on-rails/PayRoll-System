package payroll.models.benefits;

public class MonthsProportionalCalculationMethod implements
		BenefitCalculationMethod {
	private int numberOfMonths;
	
	public MonthsProportionalCalculationMethod(int numberOfMonths){
		this.numberOfMonths = numberOfMonths;
	}
	
	@Override
	public double getCalculatedValue(double initialCalculationValue) {		
		return (initialCalculationValue / 12) * numberOfMonths;
	}

}
