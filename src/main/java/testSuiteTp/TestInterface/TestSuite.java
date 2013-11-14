package testSuiteTp.TestInterface;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
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
	
	public String getXpathNavigatorRepresentation(){
		String newLine = System.getProperty("line.separator");
		String representation = "";
		representation += "<testsuite>" + newLine;
		
		if(this.activeTestSuites.size() > 0){
			representation += "<testsuites>" + newLine;
			for (TestSuite testSuite : this.activeTestSuites) {
				representation += testSuite.getXpathNavigatorRepresentation();			
			}
			representation += "</testsuites>" + newLine;
		}
		
		if(this.activeUnitTests.size() > 0){
			representation += "<testcases>" + newLine;
			for (UnitTest unitTest : this.activeUnitTests) {
				representation += unitTest.getXpathNavigatorRepresentation();			
			}
			representation += "</testcases>" + newLine;
		}
		
		representation += "<name>" + this.getName() + "</name>" + newLine;
		representation += "<timestamp>" + this.getTimeStamp() + "</timestamp>" + newLine;
		representation += "<hostname>" + this.getHostName() + "</hostName>" + newLine;
		representation += "</testsuite>" + newLine;
		return representation;
	}
	
	
	private String getTimeStamp() {
		return new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
	}

	private String getHostName() {
		try {
			return InetAddress.getLocalHost().getHostName();
		} catch (UnknownHostException e) {
			return "";
		}
	}


}
