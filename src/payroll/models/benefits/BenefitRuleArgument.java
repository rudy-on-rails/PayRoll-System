package payroll.models.benefits;

public interface BenefitRuleArgument {
	boolean shouldApplyFor(BenefitRuleArgument benefitRuleArgument);
}
