package testSuiteTp.TestInterface;
import java.util.ArrayList;
import java.util.List;

import testSuiteTp.logguer.TestLog;

public abstract class TestSuite {

	private List<UnitTest> activeTests = new ArrayList<UnitTest>();

	/**
	 * Se declaran todos los tests que componen la suite
	 */
	protected abstract void configureTests();

	/**
	 * Se define el nombre de la suite
	 * 
	 */
	protected abstract String getSuiteName();

	public void runAllTests() {
		this.configureTests();
		TestLog testLog = new TestLog(this.getSuiteName());
		for (UnitTest test : this.activeTests) {
			test.run();
			testLog.addLog(test);
		}
		testLog.showResults();
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
