package testSuiteTp.UnitTest;

import testSuiteTp.TestInterface.UnitTest;

public class UnitTest9 extends UnitTest {

	public UnitTest9(String testName) {
		super(testName);
	}

	@Override
	protected void runThis() {
		this.assertTrue("theENDisHERE" == "theENDisHERE");
	}

}
