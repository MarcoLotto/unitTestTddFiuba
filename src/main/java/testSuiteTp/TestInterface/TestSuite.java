package testSuiteTp.TestInterface;

import java.util.ArrayList;
import java.util.List;

import testSuiteTp.exceptions.TestError;
import testSuiteTp.logguer.TestLog;

public abstract class TestSuite extends TestComponent  {

	private List<TestComponent> activeTests = new ArrayList<TestComponent>();

	/**
	 * Se declaran todos los tests que componen la suite
	 */
	protected abstract void configureTests();

	protected TestSuite(String testSuiteName) {
		this.testName = testSuiteName;
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

	/**
	 * Agrega un Componente de Test a la Suite actual
	 */
	protected void add(TestComponent test) {
		this.checkNameUniqueness(test);
		test.addReferenceToParent(this);
		this.activeTests.add(test);
	}
	
	//Si 2 hermanos tienen el mismo nombre,se para la aplicación
	private void checkNameUniqueness(TestComponent TC){
		boolean retV = false;
		for (TestComponent test : this.activeTests) {
			if ( test.itHasTheSameName(TC) ){
				retV = true;
				break;
				}
		}	
		if ( retV ){ throw new TestError( TC.getName() ); }	
	}
	
	
}
