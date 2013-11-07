package testSuiteTp.logguer;

import java.util.List;

import testSuiteTp.TestInterface.UnitTest;

public class TestLog {

	public void showResults(List<UnitTest> totalTests, String suiteName) {	
		System.out.println("Tests for :" + suiteName + " #: " + totalTests.size() );
		for (UnitTest test : totalTests) {
			String message = "[" + test.getResult()+"] "+ test.getName() + ": " + test.getMessage();
			System.out.println("	" + message);
		}
		System.out.println("");
	}
}
