package payroll.models.benefits;

public interface BenefitRule {
	boolean appliesFor(BenefitRuleArgument benefitRuleArgument);
	void setLocalBenefitArgument(BenefitRuleArgument localBenefitArgument);
}
