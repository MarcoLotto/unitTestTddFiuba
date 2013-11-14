package testSuiteTp.UnitTest;

import testSuiteTp.TestInterface.TestSuite;
import testSuiteTp.logguer.ToScreenTestLog;

public class DefaultTestSuite extends TestSuite {

	public DefaultTestSuite(String testSuiteName) {
		super(testSuiteName, new ToScreenTestLog());
	}

	@Override
	protected void configureTests() {
		
	}

}
