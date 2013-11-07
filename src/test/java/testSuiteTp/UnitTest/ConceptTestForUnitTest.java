package testSuiteTp.UnitTest;

import org.junit.Test;

import testSuiteTp.TestInterface.TestSuite;

public class ConceptTestForUnitTest {

	@Test
	public void conceptUnitTest() {
		TestSuite suite = new TestSuiteForTesting1("TestSuiteForTesting1");
		suite.run();
	}

}
