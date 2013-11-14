package testSuiteTp.UnitTest;

import criteriaFiltering.Criteria;
import testSuiteTp.TestInterface.Context;
import testSuiteTp.TestInterface.TestSuite;
import testSuiteTp.TestInterface.UnitTest;
import testSuiteTp.logguer.ToScreenTestLog;

public class DefaultTestSuite extends TestSuite {

	public DefaultTestSuite(String testSuiteName) {
		super(testSuiteName, new ToScreenTestLog());
	}

	@Override
	protected void configureTests() {
		
	}

}
