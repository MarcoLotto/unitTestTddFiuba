package TP2;

import static org.junit.Assert.*;

import java.lang.annotation.Annotation;
import java.util.Date;

import org.junit.Test;
import org.junit.Before;

public class TestForFailedMemory {

	@Before
	public void setUp() {
		Reporter.clear();
	}

	@Test
	public void tesRerunWithOneFailed() {
		// Agrego un test que falle, deberia correr un total de 1 test
		TestSuite testSuite = createTestSuite();
		TP2.Test failedTest = createFailedTest("failedTest");
		testSuite.addTest(failedTest);
		Tester tester = new Tester();
		tester.addTests(testSuite);
		tester.setRunMode(RunMode.Standard);
		tester.execute();
		assertEquals(1, Reporter.getReporter().getResults().size());

		Reporter.clear();

		// Agrego un test que pase, deberia correr un total de dos tests
		TP2.Test passedTest = createPassedTest("passedTest");
		testSuite.addTest(passedTest);
		tester.setRunMode(RunMode.FailedAndNew);
		tester.execute();
		assertEquals(2, Reporter.getReporter().getResults().size());
	}

	@Test
	public void tesRerunWithOneFailedAndOnePassed() {
		// Agrego dos tests uno que falle otro que no, deberia correr un total
		// de 2 test
		TestSuite testSuite = createTestSuite();
		TP2.Test failedTest = createFailedTest("failedTest");
		TP2.Test passedTest1 = createPassedTest("passedTest1");
		testSuite.addTest(failedTest);
		testSuite.addTest(passedTest1);
		Tester tester = new Tester();
		tester.addTests(testSuite);
		tester.setRunMode(RunMode.Standard);
		tester.execute();
		assertEquals(2, Reporter.getReporter().getResults().size());

		Reporter.clear();

		// Agrego un test que pase, deberia correr un total de dos tests (no se
		// corre el que paso antes)
		TP2.Test passedTest2 = createPassedTest("passedTest2");
		testSuite.addTest(passedTest2);
		tester.setRunMode(RunMode.FailedAndNew);
		tester.execute();
		assertEquals(2, Reporter.getReporter().getResults().size());
	}

	@Test
	public void tesRerunWithOneFailedAndOnePassedInThreeExecutions() {
		//Agrego dos tests uno que falle otro que no, deberia correr un total de 2 test
		TestSuite testSuite = createTestSuite();
		TP2.Test failedTest = createFailedTest("failedTest1");
		TP2.Test passedTest1 = createPassedTest("passedTest1");
		testSuite.addTest(failedTest);
		testSuite.addTest(passedTest1);
		Tester tester = new Tester();
		tester.addTests(testSuite);
		tester.setRunMode(RunMode.Standard);
		tester.execute();
		assertEquals(2, Reporter.getReporter().getResults().size());
				
		Reporter.clear();
		
		//Agrego un test que no pase, deberia correr un total de dos tests (no se corre el que paso antes)
		TP2.Test failedTest2 = createFailedTest("failedTest2");
		testSuite.addTest(failedTest2);
		tester.setRunMode(RunMode.FailedAndNew);
		tester.execute();
		assertEquals(2, Reporter.getReporter().getResults().size());
		
		Reporter.clear();
		
		//Agrego un test que pase, deberia correr un total de dos tests (los dos que fallaron antes y este)
		TP2.Test passedTest2 = createPassedTest("passedTest2");
		testSuite.addTest(passedTest2);
		tester.setRunMode(RunMode.FailedAndNew);
		tester.execute();
		assertEquals(3, Reporter.getReporter().getResults().size());
	}

	protected TestSuite createTestSuite() {
		return new TestSuite("testSuite") {
			@Override
			protected void init() {
			}
		};
	}

	protected TP2.Test createFailedTest(String name) {
		return new TP2.Test(name) {
			@Override
			public void run() {
				Assert.isTrue(false, this.getName());
			}
		};
	}

	protected TP2.Test createPassedTest(String name) {
		return new TP2.Test(name) {
			@Override
			public void run() {
				Assert.isTrue(true, this.getName());
			}
		};
	}
}
