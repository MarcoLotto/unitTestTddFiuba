package testSuiteTp.UnitTest;

import org.junit.Test;

import testSuiteTp.TestInterface.TestSuite;

public class ConceptTestForUnitTest {

	@Test
	public void conceptUnitTest() {
		TestSuite suite = new TestSuiteForTesting("TestSuiteForTesting");
		suite.run(".*1");
	}

}
