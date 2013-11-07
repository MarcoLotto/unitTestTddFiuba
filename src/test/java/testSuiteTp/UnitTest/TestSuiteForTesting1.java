package testSuiteTp.UnitTest;

import testSuiteTp.TestInterface.Context;
import testSuiteTp.TestInterface.TestSuite;

public class TestSuiteForTesting1 extends TestSuite {

	TestSuiteForTesting1(String testSuiteName) {
		super(testSuiteName);
	}
	
	@Override
	public void setUp(Context context){
		context.setElement("suiteVariable1", "Chau", this);
	}

	@Override
	protected void configureTests() {
		//Agrego un test suite hijo
		add(new TestSuiteForTesting2("TestSuiteForTesting2 (hijo de 1)"));
		
		//Agrego tests
		add(new UnitTestForTesting1("test1"));
		add(new UnitTestForTesting2("test2"));
		add(new UnitTestForTesting3("test3"));
		add(new UnitTestForTesting4("test4"));		
	}

}
