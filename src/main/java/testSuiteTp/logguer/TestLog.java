package testSuiteTp.logguer;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import testSuiteTp.TestInterface.UnitTest;

public class TestLog {
	
	private String PathFromRoot;
	private Map<String, UnitTest> testsMaked = new HashMap<String, UnitTest>();
	
	public TestLog(){
	}
	
	public void setPath(String path){
		this.PathFromRoot = path;
	}
	
	public void processResults(List<UnitTest> totalTests){
		this.testsMaked.clear();
		for (UnitTest test : totalTests) {
			testsMaked.put(test.getName(), test);
		}
	}
	
	public void showResults() {	
		Collection<UnitTest> testsRealized = this.testsMaked.values(); 
		System.out.println("Tests for :"+this.PathFromRoot + " #: " + testsRealized.size() );
		for (UnitTest test : testsRealized) {
			String message = "[" + test.getResult()+"] "+ test.getName() + ": " + test.getMessage();
			System.out.println("	" + message);
		}
		System.out.println("");
	}	
}
