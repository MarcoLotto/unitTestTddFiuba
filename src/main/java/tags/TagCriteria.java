package tags;

import testSuiteTp.TestInterface.TestComponent;
import criteriaFiltering.Criteria;

public class TagCriteria extends Criteria<TestComponent> {
	private String tag;
	public TagCriteria(String tag){
				this.tag = tag;
	}

	@Override
	public boolean IsSatisfiedBy(TestComponent candidate) {
		return candidate.isTaggedWith(this.tag);
	}

}
