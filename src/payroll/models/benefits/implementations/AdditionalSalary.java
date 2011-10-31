package payroll.models.benefits.implementations;

import org.joda.time.LocalDate;

import payroll.models.Employee;
import payroll.models.benefits.BenefitByContraint;
import payroll.models.benefits.calculation_methods.BenefitCalculationMethod;
import payroll.models.benefits.calculation_methods.SingleValueCalculationMethod;
import payroll.models.benefits.constraints.BenefitConstraintRestrictor;
import payroll.models.benefits.constraints.arguments.BenefitConstraintArgument;
import payroll.models.benefits.constraints.arguments.EveryYearAfterFirstYearBenefitConstraintArgument;

/**
 * @author  rudyseidinger
 */
public class AdditionalSalary implements BenefitByContraint {	
	
	private BenefitConstraintRestrictor benefitRule; 	
	private Employee employee;
	
	@Override
	public double calculateBenefitValue(LocalDate calculationDate, Employee employee) {
		this.employee = employee;
		this.benefitRule = getBenefitCalculationConstraint();				
		EveryYearAfterFirstYearBenefitConstraintArgument dateMustBeAppliedRuleArgument = new EveryYearAfterFirstYearBenefitConstraintArgument(calculationDate);				
		if (this.benefitRule.doesAppliesFor(dateMustBeAppliedRuleArgument))
			return this.getBenefitCalculationMethod().getCalculatedValue(getInitialCalculationValue());
		return 0;
	}

	private double getInitialCalculationValue() {		
		return employee.getPaycheckSalary();
	}
	
	private BenefitConstraintArgument getLocalBenefitArgument() {
		return new EveryYearAfterFirstYearBenefitConstraintArgument(employee.getEmployeeHiredDate());			
	}

	@Override
	public BenefitCalculationMethod getBenefitCalculationMethod() {
		return new SingleValueCalculationMethod();
	}

	@Override
	public BenefitConstraintRestrictor getBenefitCalculationConstraint() {
		return new BenefitConstraintRestrictor(getLocalBenefitArgument());
	}
}
