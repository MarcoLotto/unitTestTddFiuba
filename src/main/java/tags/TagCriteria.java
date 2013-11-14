package tags;

import testSuiteTp.TestInterface.UnitTest;
import criteriaFiltering.Criteria;

public class TagCriteria extends Criteria<UnitTest> {
	private String tag;
	public TagCriteria(String tag){
				this.tag = tag;
	}

	@Override
	public boolean IsSatisfiedBy(UnitTest candidate) {
		return candidate.isTaggedWith(this.tag);
	}

}
