package TP2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TestMemorySlot {
	
	private List<TestSuite> runnedTestSuites = new ArrayList<TestSuite>();
	
	public List<TestSuite> getRunnedTestSuites() {
		return runnedTestSuites;
	}

	public void setRunnedTestSuites(List<TestSuite> runnedTestSuites) {
		this.runnedTestSuites = runnedTestSuites;
	}	
}
