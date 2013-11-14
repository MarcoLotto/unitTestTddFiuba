package testSuiteTp.TestInterface;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import testSuiteTp.exceptions.TestError;
import testSuiteTp.logguer.TestLog;
import testSuiteTp.logguer.ToScreenTestLog;

public abstract class TestSuite extends TestComponent {

	private List<UnitTest> activeUnitTests = new ArrayList<UnitTest>();
	private List<TestSuite> activeTestSuites = new ArrayList<TestSuite>();
	private TestLog testLog;
	private String rootPath;

	/**
	 * Se declaran todos los tests que componen la suite
	 */
	protected abstract void configureTests();

	public TestSuite(String testSuiteName, TestLog testLogImplementation) {
		this.testName = testSuiteName;
		this.rootPath = testSuiteName;
		this.testLog = testLogImplementation;
		this.testLog.setOwner(this);
		this.testLog.setPath( testSuiteName );
	}

	final public void run(Context parentContext, String regExp) {
		this.prepareContext(parentContext);
		this.configureTests();
		this.setUp(this.context);
		this.testLog.openEdition(this);
		this.testLog.logSuiteHeader(this.getPath());
		for (UnitTest test : this.activeUnitTests) {
			test.run(this.context, regExp);
			this.testLog.logResult(test);
		}
		this.testLog.logSuiteClose(this.getPath());
		
		for (TestComponent testSuite : this.activeTestSuites) {
			testSuite.run(this.context, regExp);
		}
		this.testLog.closeEdition(this);
		
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
		testSuite.setPath( this.getPath() );
		testSuite.setTestLog(this.getTestLog());
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
	
	private void setPath(String parentPath){
		this.rootPath = parentPath + "." + this.getName();		
	}
	public String getPath(){
		return this.rootPath;
	}
		
	public TestLog getTestLog() {
		return testLog;
	}

	public void setTestLog(TestLog testLog) {
		this.testLog = testLog;
	}

	public String getXpathNavigatorRepresentation(){
		String newLine = System.getProperty("line.separator");
		String representation = "";
		representation += "<testsuite>" + newLine;
		int testCount = 0, failureCount = 0, errorCount = 0;
		
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
		representation += "<tests>" + this.getTestCount() + "</tests>" + newLine;
		representation += "<failures>" + this.getCountByState(ResultEnum.FAIL) + "</failures>" + newLine;
		representation += "<errors>" + this.getCountByState(ResultEnum.ERROR) + "</errors>" + newLine;
		representation += "<timestamp>" + this.getTimeStamp() + "</timestamp>" + newLine;
		representation += "<hostname>" + this.getHostName() + "</hostName>" + newLine;
		representation += "</testsuite>" + newLine;
		return representation;
	}
	
	private int getCountByState(ResultEnum state)
	{
		int count = 0;
		for (TestSuite testSuite : this.activeTestSuites) {
			count += testSuite.getCountByState(state);
		}
		
		for (UnitTest unitTest : this.activeUnitTests) {
			if(unitTest.getResult() == state)
				count++;
		}
		
		return count ;
	}
	
	private int getTestCount(){
		int count = 0;
		for (TestSuite testSuite : this.activeTestSuites) {
			count += testSuite.getTestCount();
		}
		count += this.activeUnitTests.size();
		
		return count;
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
