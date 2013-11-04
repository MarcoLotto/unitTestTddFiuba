package testSuiteTp.TestInterface;

import java.util.ArrayList;
import java.util.List;

import testSuiteTp.logguer.TestLog;

public abstract class TestSuite extends TestComponent  {

	private List<TestComponent> activeTests = new ArrayList<TestComponent>();
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
	
	@Override
	public void run() {
		this.configureTests();
		this.setUp();
		//TestLog testLog = new TestLog();
		for (TestComponent test : this.activeTests) {
			test.run();
		}
		//testLog.showResults(this.activeTests, this.getSuiteName());
	}
	
	@Override
	protected void addReferenceToParent(TestComponent TestComp){
		TestComp.addReferenceToParent(this);		
	}

	/**
	 * Agrega un Componente de Test a la Suite actual
	 */
	protected void add(TestComponent test) {
		this.activeTests.add(test);
		test.addReferenceToParent(this);
	}
}
