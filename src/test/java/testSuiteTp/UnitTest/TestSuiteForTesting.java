package testSuiteTp.UnitTest;

import testSuiteTp.TestInterface.TestSuite;

public class TestSuiteForTesting extends TestSuite {

	@Override
	protected void configureTests() {
		addTest(new UnitTestForTesting1("test1"));
		addTest(new UnitTestForTesting2("test2"));
	}

	@Override
	protected String getSuiteName() {
		return "Test_Suite_para_pruebas";
	}

}
