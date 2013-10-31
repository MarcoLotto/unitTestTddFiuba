package testSuiteTp.TestInterface;

import java.util.ArrayList;
import java.util.List;

import testSuiteTp.logguer.TestLog;

public abstract class TestSuite {

	private List<UnitTest> activeTests = new ArrayList<UnitTest>();
	String testSuiteName;

	/**
	 * Se declaran todos los tests que componen la suite
	 */
	protected abstract void configureTests();

	protected TestSuite(String testSuiteName) {
		this.testSuiteName = testSuiteName;
	}

	public String getSuiteName() {
		return testSuiteName;
	}

	public void runAllTests() {
		this.configureTests();
		TestLog testLog = new TestLog();
		for (UnitTest test : this.activeTests) {
			test.run();
		}
		System.out.println("Tests for " + getSuiteName());
		testLog.showResults(this.activeTests);
	}

	/**
	 * Agrega un test a la suite actual
	 * 
	 * @param test
	 */
	protected void addTest(UnitTest test) {
		this.activeTests.add(test);
	}
}
