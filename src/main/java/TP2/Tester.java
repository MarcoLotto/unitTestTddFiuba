package TP2;

import java.util.LinkedList;
import java.util.List;

/** Tester
 * Su responsabilidad es agregar los testeables para poder ejecutar los
 * tests del cliente uno a uno y guardar los resultados del reporte.
 **/

public class Tester {

	private List<TestSuite> testSuites;
	private ReportMode reportMode;
	private RunMode runMode;

	public Tester() {
		testSuites = new LinkedList<TestSuite>();
		reportMode = ReportMode.Console;
		runMode = RunMode.Standard;
	}
	
	public Tester(ReportMode reportMode) {
		testSuites = new LinkedList<TestSuite>();
		this.reportMode = reportMode;
		runMode = RunMode.Standard;
	}
	
	public Tester(RunMode runMode) {
		testSuites = new LinkedList<TestSuite>();
		this.reportMode = ReportMode.Console;
		this.runMode = runMode;
	}
	
	public Tester(ReportMode reportMode, RunMode runMode) {
		testSuites = new LinkedList<TestSuite>();
		this.reportMode = reportMode;
		this.runMode = runMode;
	}

	public void addTests(TestSuite testeable) {
		testSuites.add(testeable);
	}

	public void execute() {
		Reporter.setMode(reportMode);
		for (TestSuite t : testSuites) {
			t.init();
			t.setRunMode(this.runMode);
			t.run();
		}		
		Reporter.getReporter().saveResults();
	}

}
