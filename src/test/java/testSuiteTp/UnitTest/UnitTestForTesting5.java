package testSuiteTp.UnitTest;

import testSuiteTp.TestInterface.UnitTest;

public class UnitTestForTesting5 extends UnitTest{

	protected UnitTestForTesting5(String testName) {
		super(testName);
	}

	@Override
	protected void runThis() {
		assertEquals("n00b", "n00b");
	}

}
