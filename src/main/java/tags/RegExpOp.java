package tags;

import criteriaFiltering.Criteria;
import testSuiteTp.TestInterface.UnitTest;

public class RegExpOp extends Criteria<UnitTest> {
	
	String regExp;
	
	public RegExpOp(String regExp1){
		this.regExp = regExp1;
	}

	@Override
	public boolean IsSatisfiedBy(UnitTest candidate) {
		boolean ret = (candidate.getName()).matches( this.regExp ) ;
		return ret ;
	}

}
