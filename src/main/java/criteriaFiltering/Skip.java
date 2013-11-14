package criteriaFiltering;

import testSuiteTp.TestInterface.TestComponent;

public class Skip extends Criteria<TestComponent>{

	@Override
	public boolean IsSatisfiedBy(TestComponent candidate) {
		boolean ret = candidate.isTaggedWith("SKIP");
		return ret;
	}

}
