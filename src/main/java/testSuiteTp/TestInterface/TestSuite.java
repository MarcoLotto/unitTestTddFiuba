package testSuiteTp.TestInterface;

import java.util.ArrayList;
import java.util.List;

import testSuiteTp.exceptions.TestError;
import testSuiteTp.logguer.TestLog;

public abstract class TestSuite extends TestComponent {

	private List<UnitTest> activeUnitTests = new ArrayList<UnitTest>();
	private List<TestSuite> activeTestSuites = new ArrayList<TestSuite>();
	private TestLog testLog;
	private String pathFromRoot ="";

	/**
	 * Se declaran todos los tests que componen la suite
	 */
	protected abstract void configureTests();

	public TestSuite(String testSuiteName) {
		this.testName = testSuiteName;
		this.testLog = new TestLog();
	}

	final public void run(Context parentContext, String regExp) {
		this.prepareContext(parentContext);
		this.configureTests();
		this.setUp(this.context);
		this.testLog.setPath( this.pathFromRoot + this.getName() );
		for (TestComponent test : this.activeUnitTests) {
			test.run(this.context, regExp);
		}
		testLog.processResults(this.activeUnitTests);
		testLog.showResults();
		
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

	final public void add(TestSuite testSuite) {
		this.addToList(testSuite,this.activeTestSuites );
		if ( this.ParentTest != null){
			testSuite.setPath( this.pathFromRoot + this.getName() + "." );
		}
		else{
			testSuite.setPath( this.getName() + "." );				
		}
	}

	final public void add(UnitTest unitTest) {
		this.addToList(unitTest,this.activeUnitTests);
	}
	
	private <T extends TestComponent> void addToList(T testC,List<T> activeTests){
		this.checkNameUniqueness(testC, activeTests);	
		activeTests.add(testC);
		testC.addReferenceToParent(this);
	}

	// Si 2 hermanos tienen el mismo nombre,se para la aplicación
	private <T extends TestComponent> void  checkNameUniqueness(T testC,List<T> activeTests) {
		boolean retV = false;
		for (TestComponent test : activeTests) {
			if (test.itHasTheSameName(testC)) {
				retV = true;
				break;
			}
		}
		if (retV) {
			throw new TestError(testC.getName());
		}
	}
	
	private void setPath(String path){
		this.pathFromRoot = path;		
	}
	public String getPath(){
		return this.pathFromRoot;
	}

}
