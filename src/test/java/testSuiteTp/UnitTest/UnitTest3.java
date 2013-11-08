package testSuiteTp.UnitTest;

import testSuiteTp.TestInterface.UnitTest;

public class UnitTest3 extends UnitTest{

	public UnitTest3(String testName) {
		super(testName);
	}

	@Override
	protected void runThis() {
		assertEquals("1", "1");
		assertTrue(56667==56667);
		assertFalse( "nunca" == "siempre" );
				
	}

}
