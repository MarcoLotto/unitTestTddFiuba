package testSuiteTp.UnitTest;

import testSuiteTp.TestInterface.UnitTest;

public class UnitTestForTesting1 extends UnitTest{

	UnitTestForTesting1(String testName) {
		super(testName);
	}

	@Override
	public void runThis() {
		assertEquals("Hola", "Hola");
		assertTrue(1==1);
		assertFalse("Chau".equals("hola") );
	}

}
