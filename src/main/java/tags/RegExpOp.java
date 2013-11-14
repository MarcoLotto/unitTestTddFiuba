package tags;

import criteriaFiltering.Criteria;
import testSuiteTp.TestInterface.TestComponent;

public class RegExpOp extends Criteria<TestComponent> {
	
	String regExp;
	
	public RegExpOp(String regExp1){
		this.regExp = regExp1;
	}

	@Override
	public boolean IsSatisfiedBy(TestComponent candidate) {
		boolean ret = candidate.getName().matches( this.regExp ) ;
		return ret ;
	}

}
