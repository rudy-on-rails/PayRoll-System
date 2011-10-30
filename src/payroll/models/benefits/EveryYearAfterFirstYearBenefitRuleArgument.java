package payroll.models.benefits;


import org.joda.time.LocalDate;


import payroll.helpers.DateHelper;

/**
 * @author  rudyseidinger
 */
public class EveryYearAfterFirstYearBenefitRuleArgument implements BenefitRuleArgument {
	/**
	 * @uml.property  name="currentCheckingLocalDate"
	 */
	private LocalDate currentCheckingLocalDate;
	
	/**
	 * @return
	 * @uml.property  name="currentCheckingLocalDate"
	 */
	public LocalDate getCurrentCheckingLocalDate() {
		return currentCheckingLocalDate;
	}
	/**
	 * @param currentCheckingLocalDate
	 * @uml.property  name="currentCheckingLocalDate"
	 */
	public void setCurrentCheckingLocalDate(LocalDate currentCheckingLocalDate) {
		this.currentCheckingLocalDate = currentCheckingLocalDate;
	}
	@Override
	public boolean shouldApplyFor(BenefitRuleArgument benefitRuleArgument) {
		if (!(benefitRuleArgument instanceof EveryYearAfterFirstYearBenefitRuleArgument))
			return false;
		else{
			EveryYearAfterFirstYearBenefitRuleArgument benefitArgumentRuleParam = (EveryYearAfterFirstYearBenefitRuleArgument) benefitRuleArgument;
			return DateHelper.NumberOfYears(getCurrentCheckingLocalDate(), benefitArgumentRuleParam.getCurrentCheckingLocalDate()) >= 1 && DateHelper.IsOnSameMonth(currentCheckingLocalDate, benefitArgumentRuleParam.getCurrentCheckingLocalDate());
		}
	}
}
