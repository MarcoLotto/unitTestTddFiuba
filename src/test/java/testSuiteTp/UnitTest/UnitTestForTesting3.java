package testSuiteTp.UnitTest;

import testSuiteTp.TestInterface.Context;
import testSuiteTp.TestInterface.UnitTest;

public class UnitTestForTesting3 extends UnitTest{

	protected UnitTestForTesting3(String testName) {
		super(testName);
	}

	@Override
	protected void runThis(Context context) {
		assertEquals("1", "1");
		assertTrue(56667==56667);
		assertFalse( "nunca" == "siempre" );
				
	}

}
