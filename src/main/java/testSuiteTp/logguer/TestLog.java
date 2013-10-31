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
		// feature envy ?
		// este if no me gusta =$
		if (test.hasPassed()) {
			this.passedTests.add(test);
		} else {
			this.failedTests.add(test);
		}
	}

	public void showResults() {
		System.out.println("Tests for " + this.suiteName);
		System.out.println("Failed: " + this.failedTests.size());
		for (UnitTest test : this.failedTests) {
			String message = test.getName() + ": " + test.getExceptionMessage();
			System.out.println("	" + message);
		}
		System.out.println("Passed: " + this.passedTests.size());
		for (UnitTest test : this.passedTests) {
			System.out.println("	" + test.getName());
		}
	}

}
