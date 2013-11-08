package testSuiteTp.UnitTest;

import testSuiteTp.TestInterface.TestSuite;

public class RegExpTest extends TestSuite {

	public RegExpTest(String testSuiteName) {
		super(testSuiteName);
	}

	@Override
	protected void configureTests() {
		add(new UnitTest2("HOLAxxx"));
		add(new UnitTest3("xxxHOLAxxx") );
		add(new UnitTest3("hola"));
		add(new UnitTest4("test4"));
		add(new UnitTest2("xHxOLA"));
	}

}
