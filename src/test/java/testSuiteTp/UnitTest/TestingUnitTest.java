package testSuiteTp.UnitTest;

import org.junit.Test;

import testSuiteTp.TestInterface.TestSuite;

public class TestingUnitTest {

	@Test
	public void conceptUnitTest() { //Solo para probar como funciona
		TestSuite suite = new TestSuiteForTesting("TestSuiteForTesting");
		suite.runAllTests();
	}

}
