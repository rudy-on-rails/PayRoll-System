package payroll.models.benefits.constraints;

import payroll.models.benefits.constraints.arguments.BenefitConstraintArgument;


/**
 * @author  rudyseidinger
 */
public final class BenefitConstraint {
	
	private BenefitConstraintArgument localBenefitArgument;
	
	public BenefitConstraint(BenefitConstraintArgument initialBenefitConstraintArgument){
		this.localBenefitArgument = initialBenefitConstraintArgument;
	}
	
	public boolean appliesFor(BenefitConstraintArgument benefitRuleArgument) {		
		return this.localBenefitArgument.canBeAppliedFor(benefitRuleArgument);
	}					
}
