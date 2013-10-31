package testSuiteTp.UnitTest;

import testSuiteTp.TestInterface.UnitTest;

public class UnitTestForTesting2 extends UnitTest{

	UnitTestForTesting2(String testName) {
		super(testName);
	}

	@Override
	public void runThis() {
		assertEquals("Chau", "Hola");
	}
}
