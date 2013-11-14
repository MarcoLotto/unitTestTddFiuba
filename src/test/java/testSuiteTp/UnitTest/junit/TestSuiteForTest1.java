package testSuiteTp.UnitTest.junit;

import testSuiteTp.TestInterface.Context;
import testSuiteTp.TestInterface.TestSuite;
import testSuiteTp.logguer.ToScreenTestLog;

public class TestSuiteForTest1 extends TestSuite {

	public TestSuiteForTest1(String testSuiteName) {
		super(testSuiteName, new ToScreenTestLog());
	}
	
	
	@Override
	protected void configureTests() {			
	}

}
