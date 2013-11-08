package testSuiteTp.UnitTest;

import testSuiteTp.TestInterface.Context;
import testSuiteTp.TestInterface.UnitTest;

public class UnitTest5 extends UnitTest{

	protected UnitTest5(String testName) {
		super(testName);
	}

	@Override
	protected void runThis(Context context) {
		//Consigo una variable de la testSuite 2, modifico su valor y verifico que haya cambiado
		int suiteVariable2 = (Integer) context.getElement("suiteVariable2");
		assertEquals(5, suiteVariable2);
		
		context.setElement("suiteVariable2", 10, this);
		suiteVariable2 = (Integer) context.getElement("suiteVariable2");
		assertEquals(10, suiteVariable2);
	}

}
