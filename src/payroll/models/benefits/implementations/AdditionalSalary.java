package payroll.models.benefits.implementations;

import org.joda.time.LocalDate;

import payroll.models.Employee;
import payroll.models.benefits.BasedOnDateBenefitRule;
import payroll.models.benefits.BenefitByRule;
import payroll.models.benefits.BenefitCalculationMethod;
import payroll.models.benefits.BenefitRule;
import payroll.models.benefits.BenefitRuleArgument;
import payroll.models.benefits.EveryYearAfterFirstYearBenefitRuleArgument;
import payroll.models.benefits.SingleValueCalculationMethod;

/**
 * @author  rudyseidinger
 */
public class AdditionalSalary implements BenefitByRule {	
	
	private BenefitRule benefitRule; 	
	
	@Override
	public double calculateBenefitValue(LocalDate calculationDate, Employee employee) {		
		this.benefitRule = getBenefitCalculationRule();		
		this.benefitRule.setLocalBenefitArgument(this.getLocalBenefitArgument(employee));
		EveryYearAfterFirstYearBenefitRuleArgument dateMustBeAppliedRuleArgument = new EveryYearAfterFirstYearBenefitRuleArgument();
		dateMustBeAppliedRuleArgument.setCurrentCheckingLocalDate(calculationDate);		
		if (this.benefitRule.appliesFor(dateMustBeAppliedRuleArgument))
			return this.getBenefitCalculationMethod().getCalculatedValue(getInitialCalculationValue(employee));
		return 0;
	}

	private double getInitialCalculationValue(Employee employee) {		
		return employee.getPaycheckSalary();
	}
	
	private BenefitRuleArgument getLocalBenefitArgument(Employee employee) {
		EveryYearAfterFirstYearBenefitRuleArgument everyYearBenefitRuleArgument = new EveryYearAfterFirstYearBenefitRuleArgument();
		everyYearBenefitRuleArgument.setCurrentCheckingLocalDate(employee.getEmployeeHiredDate());
		return everyYearBenefitRuleArgument;
	}

	@Override
	public BenefitCalculationMethod getBenefitCalculationMethod() {
		return new SingleValueCalculationMethod();
	}

	@Override
	public BenefitRule getBenefitCalculationRule() {
		return new BasedOnDateBenefitRule();
	}
}
