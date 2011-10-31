package payroll.models.benefits;

import payroll.models.benefits.constraints.BenefitConstraint;

public interface BenefitByContraint extends Benefit {
	public abstract BenefitConstraint getBenefitCalculationConstraint();
}