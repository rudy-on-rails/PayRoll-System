package payroll.models.benefits;

public interface BenefitByRule extends Benefit {
	public abstract BenefitRule getBenefitCalculationRule();
}