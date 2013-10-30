package testSuiteTp.logguer;

import java.util.ArrayList;
import java.util.List;

import testSuiteTp.TestInterface.UnitTest;

public class TestLog {

	private List<UnitTest> passedTests = new ArrayList<UnitTest>();
	private List<UnitTest> failedTests = new ArrayList<UnitTest>();
	private String suiteName;

	public TestLog(String suiteName) {
		this.suiteName = suiteName;
	}

	public void addLog(UnitTest test) {
		if (test.getState().isPassed()) {
			this.passedTests.add(test);
		} else {
			this.failedTests.add(test);
		}
	}

	public void showResults() {
		System.out.println("Tests for " + this.suiteName);
		System.out.println("Failed: " + this.failedTests.size());
		for (UnitTest test : this.failedTests) {
			Exception testFailException = test.getState().getFailException();
			String message = test.getName() + ": " + testFailException.getMessage();
			System.out.println("	" + message);
		}
		System.out.println("Passed: " + this.passedTests.size());
		for (UnitTest test : this.passedTests) {
			System.out.println("	" + test.getName());
		}
	}

}
