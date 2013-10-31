package testSuiteTp.UnitTest;

import testSuiteTp.TestInterface.UnitTest;

public class UnitTestForTesting1 extends UnitTest{

	@Override
	public void run() {
		assertEquals("Hola", "Hola");
		assertTrue(1==1);
		assertFalse("Chau".equals("hola") );
	}

	@Override
	public String getName() {
		return "Unit_test_1";
	}

}
