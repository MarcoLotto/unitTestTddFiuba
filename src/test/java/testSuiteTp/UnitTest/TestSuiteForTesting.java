package testSuiteTp.UnitTest;

import testSuiteTp.TestInterface.TestSuite;

public class TestSuiteForTesting extends TestSuite {

	TestSuiteForTesting(String testSuiteName) {
		super(testSuiteName);
	}

	@Override
	protected void configureTests() {
		add(new UnitTestForTesting1("test1"));
		add(new UnitTestForTesting2("test2"));
		add(new UnitTestForTesting3("test3"));
		add(new UnitTestForTesting4("test4"));
	}

}
