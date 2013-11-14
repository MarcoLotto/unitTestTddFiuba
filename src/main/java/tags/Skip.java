package tags;

import criteriaFiltering.Criteria;
import testSuiteTp.TestInterface.UnitTest;

public class Skip extends Criteria<UnitTest>{

	@Override
	public boolean IsSatisfiedBy(UnitTest candidate) {
		boolean ret = candidate.isTaggedWith("SKIP");
		return !ret;
	}

}
