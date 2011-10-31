package payroll.models.benefits.constraints;

import payroll.models.benefits.constraints.arguments.BenefitConstraintArgument;


/**
 * @author  rudyseidinger
 */
public final class BenefitConstraintRestrictor {
	
	private BenefitConstraintArgument localBenefitArgument;
	
	public BenefitConstraintRestrictor(BenefitConstraintArgument initialBenefitConstraintArgument){
		this.localBenefitArgument = initialBenefitConstraintArgument;
	}
	
	public boolean doesAppliesFor(BenefitConstraintArgument benefitRuleArgument) {		
		return this.localBenefitArgument.canBeAppliedFor(benefitRuleArgument);
	}					
}
