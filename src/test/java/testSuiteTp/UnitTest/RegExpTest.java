package testSuiteTp.UnitTest;

import testSuiteTp.TestInterface.TestSuite;

public class RegExpTest extends TestSuite {

	protected RegExpTest(String testSuiteName) {
		super(testSuiteName);
	}

	@Override
	protected void configureTests() {
		add(new UnitTestForTesting2("HOLAxxx"));
		add(new UnitTestForTesting3("xxxHOLAxxx") );
		add(new UnitTestForTesting3("hola"));
		add(new UnitTestForTesting4("test4"));
		add(new UnitTestForTesting2("xHxOLA"));
	}

}
