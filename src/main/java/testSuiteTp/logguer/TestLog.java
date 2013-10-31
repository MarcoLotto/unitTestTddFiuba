package testSuiteTp.logguer;

import java.util.ArrayList;
import java.util.List;

import testSuiteTp.TestInterface.UnitTest;

public class TestLog {

	public void showResults(List<UnitTest> totalTests, String suiteName) {		
		List<UnitTest> passedTests = new ArrayList<UnitTest>();
		List<UnitTest> failedTests = new ArrayList<UnitTest>();
		
		this.filterPassedFailed(totalTests, passedTests, failedTests);
		
		System.out.println("Tests for " + suiteName);
		System.out.println("Failed: " + failedTests.size());
		for (UnitTest test : failedTests) {
			String message = test.getName() + ": " + test.getExceptionMessage();
			System.out.println("	" + message);
		}
		System.out.println("Passed: " + passedTests.size());
		for (UnitTest test : passedTests) {
			System.out.println("	" + test.getName());
		}
	}

	private void filterPassedFailed(List<UnitTest> totalTests,List<UnitTest> passedT,List<UnitTest> failedT){
		for(UnitTest test : totalTests){
			if (test.hasPassed()) {
				passedT.add(test);
			} else {
				failedT.add(test);
			}
		}
	}

}
