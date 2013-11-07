package testSuiteTp.TestInterface;

import java.util.ArrayList;
import java.util.List;

import testSuiteTp.exceptions.TestError;
import testSuiteTp.logguer.TestLog;

public abstract class TestSuite extends TestComponent {

	private List<UnitTest> activeUnitTests = new ArrayList<UnitTest>();
	private List<TestSuite> activeTestSuites = new ArrayList<TestSuite>();

	/**
	 * Se declaran todos los tests que componen la suite
	 */
	protected abstract void configureTests();

	protected TestSuite(String testSuiteName) {
		this.testName = testSuiteName;
	}

	public void run(Context parentContext, String regExp) {
		this.prepareContext(parentContext);
		this.configureTests();
		this.setUp(this.context);
		TestLog testLog = new TestLog();
		for (TestComponent test : this.activeUnitTests) {
			test.run(this.context, regExp);
		}
		testLog.showResults(this.activeUnitTests, this.getName());

		for (TestComponent testSuite : this.activeTestSuites) {
			testSuite.run(this.context, regExp);
		}
	}

	/**
	 * Mergea el contexto actual con el del padre y resetea o marca como sucio
	 * todo el contexto
	 * 
	 * @param parentContext
	 */
	private void prepareContext(Context parentContext) {
		this.mergeWithParentContext(parentContext);
		this.context.resetContext();
	}

	/**
	 * Agrega un Componente de Test a la Suite actual
	 */
	// POR FAVOR REFACTORIZAR
	protected void add(TestSuite testSuite) {
		this.checkNameUniqueness(testSuite, this.activeTestSuites);
		this.activeTestSuites.add(testSuite);
		testSuite.addReferenceToParent(this);
	}

	protected void add(UnitTest unitTest) {
		this.checkNameUniqueness(unitTest, this.activeUnitTests);
		this.activeUnitTests.add(unitTest);
		unitTest.addReferenceToParent(this);
	}

	// private void addToList(TestComponent testComponent, List activeTests) {}

	// Si 2 hermanos tienen el mismo nombre,se para la aplicación
	private void checkNameUniqueness(TestComponent testComponent,
			List activeTests) {
		boolean retV = false;
		for (TestComponent test : (List<TestComponent>) activeTests) {
			if (test.itHasTheSameName(testComponent)) {
				retV = true;
				break;
			}
		}
		if (retV) {
			throw new TestError(testComponent.getName());
		}
	}

}
