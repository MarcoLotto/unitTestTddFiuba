package testSuiteTp.UnitTest;

import testSuiteTp.TestInterface.Context;
import testSuiteTp.TestInterface.UnitTest;

public class UnitTestForTesting6 extends UnitTest{

	protected UnitTestForTesting6(String testName) {
		super(testName);
	}

	@Override
	protected void runThis(Context context) {
		//Consigo una variable de la testSuite 2 y verifico que su valor permanezca inmutable
		int suiteVariable2 = (Integer) context.getElement("suiteVariable2");
		assertEquals(5, suiteVariable2);
	}

}
