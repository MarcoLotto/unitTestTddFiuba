package testSuiteTp.UnitTest;

import testSuiteTp.TestInterface.UnitTest;

public class UnitTest7 extends UnitTest{

	public UnitTest7(String testName) {
		super(testName);
	}

	@Override
	protected void runThis() {
		this.assertFalse("theskyisred"=="false");		
	}

}
