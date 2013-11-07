package testSuiteTp.logguer;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import testSuiteTp.TestInterface.UnitTest;

public class TestLog {
	
	private String suiteName;
	private Map<String, UnitTest> testsMaked = new HashMap<String, UnitTest>();
	
	public TestLog(String suiteName){
		this.suiteName = suiteName;
	}
	
	public void processResults(List<UnitTest> totalTests){
		this.testsMaked.clear();
		for (UnitTest test : totalTests) {
			testsMaked.put(test.getName(), test);
		}
	}
	
	public void showResults() {	
		Collection<UnitTest> testsRealized = this.testsMaked.values(); 
		System.out.println("Tests for :" + this.suiteName + " #: " + testsRealized.size() );
		for (UnitTest test : testsRealized) {
			String message = "[" + test.getResult()+"] "+ test.getName() + ": " + test.getMessage();
			System.out.println("	" + message);
		}
		System.out.println("");
	}
	
	public UnitTest getUnitTest(String testName){
		return this.testsMaked.get(testName);
	}	
}
