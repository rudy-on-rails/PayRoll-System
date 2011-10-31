package payroll.models.benefits.constraints.arguments;


import org.joda.time.LocalDate;


import payroll.helpers.DateHelper;

/**
 * @author  rudyseidinger
 */
public class EveryYearAfterFirstYearBenefitConstraintArgument implements BenefitConstraintArgument {	
	private LocalDate currentCheckingLocalDate;
	
	public EveryYearAfterFirstYearBenefitConstraintArgument(LocalDate currentCheckingLocalDate){
		this.currentCheckingLocalDate = currentCheckingLocalDate;
	}
	
	public LocalDate getCurrentCheckingLocalDate() {
		return currentCheckingLocalDate;
	}
		
	@Override
	public boolean canBeAppliedFor(BenefitConstraintArgument benefitRuleArgument) {
		if (!(benefitRuleArgument instanceof EveryYearAfterFirstYearBenefitConstraintArgument))
			return false;
		else{
			EveryYearAfterFirstYearBenefitConstraintArgument benefitArgumentRuleParam = (EveryYearAfterFirstYearBenefitConstraintArgument) benefitRuleArgument;
			return DateHelper.NumberOfYears(getCurrentCheckingLocalDate(), benefitArgumentRuleParam.getCurrentCheckingLocalDate()) >= 1 && DateHelper.IsOnSameMonth(currentCheckingLocalDate, benefitArgumentRuleParam.getCurrentCheckingLocalDate());
		}
	}
}
