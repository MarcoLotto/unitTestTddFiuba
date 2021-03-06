package testSuiteTp.UnitTest;

import testSuiteTp.TestInterface.Context;
import testSuiteTp.TestInterface.TestSuite;
import testSuiteTp.logguer.ToFileTestLog;
import testSuiteTp.logguer.ToScreenTestLog;

public class TestSuiteForTesting1 extends TestSuite {

	public TestSuiteForTesting1(String testSuiteName) {
		super(testSuiteName, new ToScreenTestLog());
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
		add(new UnitTest1("test1"));
		add(new UnitTest2("test2"));
		add(new UnitTest3("test3"));
		add(new UnitTest4("test4"));		
	}

}
