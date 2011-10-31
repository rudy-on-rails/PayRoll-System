package payroll.models.benefits.implementations;

import org.joda.time.LocalDate;

import payroll.models.Employee;
import payroll.models.benefits.BenefitByContraint;
import payroll.models.benefits.calculation_methods.BenefitCalculationMethod;
import payroll.models.benefits.calculation_methods.SingleValueCalculationMethod;
import payroll.models.benefits.constraints.BenefitConstraint;
import payroll.models.benefits.constraints.arguments.BenefitConstraintArgument;
import payroll.models.benefits.constraints.arguments.EveryYearAfterFirstYearBenefitConstraintArgument;

/**
 * @author  rudyseidinger
 */
public class AdditionalSalary implements BenefitByContraint {	
	
	private BenefitConstraint benefitRule; 	
	private Employee employee;
	
	@Override
	public double calculateBenefitValue(LocalDate calculationDate, Employee employee) {
		this.employee = employee;
		this.benefitRule = getBenefitCalculationConstraint();				
		EveryYearAfterFirstYearBenefitConstraintArgument dateMustBeAppliedRuleArgument = new EveryYearAfterFirstYearBenefitConstraintArgument();
		dateMustBeAppliedRuleArgument.setCurrentCheckingLocalDate(calculationDate);		
		if (this.benefitRule.appliesFor(dateMustBeAppliedRuleArgument))
			return this.getBenefitCalculationMethod().getCalculatedValue(getInitialCalculationValue());
		return 0;
	}

	private double getInitialCalculationValue() {		
		return employee.getPaycheckSalary();
	}
	
	private BenefitConstraintArgument getLocalBenefitArgument() {
		EveryYearAfterFirstYearBenefitConstraintArgument everyYearBenefitRuleArgument = new EveryYearAfterFirstYearBenefitConstraintArgument();
		everyYearBenefitRuleArgument.setCurrentCheckingLocalDate(employee.getEmployeeHiredDate());
		return everyYearBenefitRuleArgument;
	}

	@Override
	public BenefitCalculationMethod getBenefitCalculationMethod() {
		return new SingleValueCalculationMethod();
	}

	@Override
	public BenefitConstraint getBenefitCalculationConstraint() {
		return new BenefitConstraint(getLocalBenefitArgument());
	}
}
