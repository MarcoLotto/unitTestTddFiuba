package testSuiteTp.UnitTest;

import testSuiteTp.TestInterface.TestSuite;

public class TestSuiteForTesting extends TestSuite {

	TestSuiteForTesting(String testSuiteName) {
		super(testSuiteName);
	}

	@Override
	protected void configureTests() {
		addTest(new UnitTestForTesting1("test1"));
		addTest(new UnitTestForTesting2("test2"));
	}

}
