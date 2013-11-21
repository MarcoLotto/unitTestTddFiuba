package TP2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Tester Su responsabilidad es agregar los testeables para poder ejecutar los
 * tests del cliente uno a uno y guardar los resultados del reporte.
 **/

public class Tester {

	private List<TestSuite> testSuites;
	private List<TestMemorySlot> alreadyRunnedTests = new ArrayList<TestMemorySlot>();
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
	
	public void setRunMode(RunMode runMode) {
		this.runMode = runMode;
	}

	public void addTests(TestSuite testeable) {
		testSuites.add(testeable);
	}

	/**
	 * Ejecuta los test activos en el tester. Si se indica que el recovery mode esta activo se
	 * correran ademas primero los tests que fallaron la corrida pasada y luego los actuales.
	 */
	public void execute() {
		Reporter.setMode(reportMode);
		if (this.runMode.equals(RunMode.Recover)) {
			this.executeRecoverTest();
		}
		else if (this.runMode.equals(RunMode.Standard)) {
			this.executeTests(this.testSuites);
		}
		
		this.saveRunInMemory();
		Reporter.getReporter().saveResults();
	}

	private void executeTests(List<TestSuite> testsSuitesToRun) {
		for (TestSuite t : testsSuitesToRun) {
			t.init();
			t.setRunMode(this.runMode);
			t.run();
		}		
	}

	private void executeRecoverTest(){
		int memoryCount = this.alreadyRunnedTests.size(); 
		if(memoryCount == 0){
			return;
		}		
		TestMemorySlot memory = this.alreadyRunnedTests.get(memoryCount-1);
		for (TestSuite t : memory.getRunnedTestSuites()) {
			t.init();
			t.setRunMode(this.runMode);
			t.runFailedAndNotTested();
		}		
	}

	private void saveRunInMemory() {
		TestMemorySlot memory = new TestMemorySlot();
		memory.setRunnedTestSuites(this.testSuites);
		this.alreadyRunnedTests.add(memory);
	}

}
