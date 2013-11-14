package criteriaFiltering;

import testSuiteTp.TestInterface.TestComponent;

public class NullCriteria extends Criteria<TestComponent> {

	@Override
	public boolean IsSatisfiedBy(TestComponent candidate) {
		return true;
	}



}
