package payroll.models.benefits;

/**
 * @author  rudyseidinger
 */
public class BasedOnDateBenefitRule implements BenefitRule {
	
	private BenefitRuleArgument localBenefitArgument;
	
	@Override
	public boolean appliesFor(BenefitRuleArgument benefitRuleArgument) {		
		return this.localBenefitArgument.shouldApplyFor(benefitRuleArgument);
	}

	
	public BenefitRuleArgument getLocalBenefitArgument() {
		return localBenefitArgument;
	}

	
	public void setLocalBenefitArgument(BenefitRuleArgument localBenefitArgument) {
		this.localBenefitArgument = localBenefitArgument;
	}
					
}
