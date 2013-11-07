package testSuiteTp.UnitTest;

import testSuiteTp.TestInterface.Context;
import testSuiteTp.TestInterface.TestSuite;

public class TestSuiteForTesting2 extends TestSuite {

	TestSuiteForTesting2(String testSuiteName) {
		super(testSuiteName);
	}
	
	@Override
	public void setUp(Context context){
		context.setElement("suiteVariable2", 5, this);
	}

	@Override
	protected void configureTests() {
		add(new UnitTestForTesting1("test1"));
		add(new UnitTestForTesting2("test2"));
		add(new UnitTestForTesting3("test3"));
		add(new UnitTestForTesting5("test5"));
		add(new UnitTestForTesting6("test6"));
	}

}
