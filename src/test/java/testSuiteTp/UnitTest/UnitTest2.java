package testSuiteTp.UnitTest;

import testSuiteTp.TestInterface.UnitTest;

public class UnitTest2 extends UnitTest{

	public UnitTest2(String testName) {
		super(testName);
	}

	@Override
	public void runThis() {
		assertEquals("Chau", "Hola");
	}
}
