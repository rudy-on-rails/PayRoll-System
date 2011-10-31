package payroll.models.benefits;

import payroll.models.benefits.constraints.BenefitConstraintRestrictor;

public interface BenefitByContraint extends Benefit {
	public abstract BenefitConstraintRestrictor getBenefitCalculationConstraint();
}