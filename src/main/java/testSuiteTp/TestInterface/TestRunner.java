package testSuiteTp.TestInterface;

import criteriaFiltering.Criteria;

//esta es la clase que necesita piecho
public class TestRunner extends TestComponent{
	TestComponent root;
	
	public TestRunner(TestComponent root){
		this.root = root;
	}


	public String getXpathNavigatorRepresentation() {
		return this.root.getXpathNavigatorRepresentation();
	}


	@Override
	public void run(Context parentContext, String regExp,Criteria<UnitTest> criteria) {
		this.root.run(parentContext,regExp,criteria);		
	}

}
