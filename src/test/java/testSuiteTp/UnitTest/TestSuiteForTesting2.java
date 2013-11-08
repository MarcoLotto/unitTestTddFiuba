package testSuiteTp.UnitTest;

import testSuiteTp.TestInterface.Context;
import testSuiteTp.TestInterface.TestSuite;

public class TestSuiteForTesting2 extends TestSuite {

	public TestSuiteForTesting2(String testSuiteName) {
		super(testSuiteName);
	}
	
	@Override
	public void setUp(Context context){
		context.setElement("suiteVariable2", 5, this);
	}

	@Override
	protected void configureTests() {
		add(new UnitTest1("test1"));
		add(new UnitTest2("test2"));
		add(new UnitTest3("test3"));
		add(new UnitTest5("test5"));
		add(new UnitTest6("test6"));
	}

}
