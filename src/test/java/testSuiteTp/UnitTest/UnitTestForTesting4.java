package testSuiteTp.UnitTest;

import testSuiteTp.TestInterface.UnitTest;

public class UnitTestForTesting4 extends UnitTest {

	protected UnitTestForTesting4(String testName) {
		super(testName);
	}

	@Override
	protected void runThis() {
		this.assertFalse(1==3);
		this.assertFalse(false);
		this.assertTrue(true);
		this.assertEquals("@", "@");
	}

}
