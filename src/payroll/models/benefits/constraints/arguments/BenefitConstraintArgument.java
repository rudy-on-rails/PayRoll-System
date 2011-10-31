package payroll.models.benefits.constraints.arguments;

public interface BenefitConstraintArgument {
	boolean canBeAppliedFor(BenefitConstraintArgument benefitRuleArgument);
}
