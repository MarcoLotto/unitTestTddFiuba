package tags;

import junit.framework.TestCase;
import criteriaFiltering.Criteria;

public class RegExpTestCase extends Criteria<TestCase>{
	String regExp;
	
	public RegExpTestCase(String regExp1){
		this.regExp = regExp1;
	}
	@Override
	public boolean IsSatisfiedBy(TestCase candidate) {
		boolean ret = candidate.getName().matches(this.regExp) ;
		return ret;
	}


}
