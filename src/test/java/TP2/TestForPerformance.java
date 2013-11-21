package TP2;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

public class TestForPerformance {

	/**
	 * Creo y corro un test de performance con 10 segundos de top time. Deberia pasar.
	 */
	@Test
	public void performanceTestPassed() {
		Reporter.clear();
		double topRunTime = 10;
		PerformanceTest performanceTest = new TP2.PerformanceTest("performance", topRunTime) {
			@Override
			public void runPerformanceTest() {
				Assert.isTrue(true, "performance");
			}
		};
		runTest(performanceTest);
		assertEquals(0, Reporter.getReporter().getFailures().size());
	}
	
	/**
	 * Creo y corro un test de performance con 3 segundos de top time pero 4 de run time del test.
	 * No deberia pasar.
	 */
	@Test
	public void performanceTestNotPassed() {
		Reporter.clear();
		double topRunTime = 3;
		PerformanceTest performanceTest = new TP2.PerformanceTest("performance", topRunTime) {
			@Override
			public void runPerformanceTest() {
				Date before = TimerUtils.getCurrentTime();
				while(TimerUtils.calculateTimeInSeconds(before) < 4){
					//Nada, solo quiero que tarde 4 segundos					
				}
			}
		};
		runTest(performanceTest);
		assertEquals(1, Reporter.getReporter().getFailures().size());
	}

	private void runTest(TP2.Test test) {
		TestSuite testSuite = new TestSuite("testSuite") {
			@Override
			protected void init() {
			}
		};
		testSuite.addTest(test);
		testSuite.init();
		testSuite.run();
	}

}
