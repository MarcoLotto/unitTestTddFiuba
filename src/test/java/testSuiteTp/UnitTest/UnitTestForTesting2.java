package testSuiteTp.UnitTest;

import testSuiteTp.TestInterface.UnitTest;

public class UnitTestForTesting2 extends UnitTest{

	@Override
	public void run() {
		assertEquals("Chau", "Hola");
	}

	@Override
	public String getName() {
		return "Unit_test_2";
	}
}
