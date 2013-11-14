package tags;

import junit.framework.TestCase;
import testSuiteTp.TestInterface.TestComponent;
import criteriaFiltering.Criteria;

public class RegExpTestCase extends Criteria<TestComponent>{
	String regExp;
	
	public RegExpTestCase(String regExp1){
		this.regExp = regExp1;
	}
	@Override
	public boolean IsSatisfiedBy(TestComponent candidate) {
		boolean ret = candidate. ;
		return ret;
	}


}
