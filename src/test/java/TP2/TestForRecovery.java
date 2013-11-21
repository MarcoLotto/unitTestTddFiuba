package TP2;

import static org.junit.Assert.*;

import java.lang.annotation.Annotation;
import java.util.Date;

import org.junit.Test;
import org.junit.Before;

public class TestForRecovery {

	@Before
	public void setUp() {
		Reporter.clear();
	}

	@Test
	public void testBasicRecovery() {
		// Agrego un test para recovery
		TestSuite testSuite = createTestSuite();
		TP2.Test failedTest = createFailedTest("failedTest");
		testSuite.addTest(failedTest);
		Tester tester = new Tester();
		tester.addTests(testSuite);
		tester.setRunMode(RunMode.Standard);
		tester.executeAndSaveRunInMemorySlot("recover1");
		assertEquals(1, Reporter.getReporter().getResults().size());

		Reporter.clear();

		// Recuero el test
		tester.setRunMode(RunMode.Recover);
		tester.setRecoveryEntry("recover1");
		tester.execute();
		assertEquals(1, Reporter.getReporter().getResults().size());
	}


	@Test
	public void testComplexRecovery() {
		// Agrego un test para recovery
		TestSuite testSuite = createTestSuite();
		TP2.Test failedTest = createFailedTest("failedTest");
		testSuite.addTest(failedTest);
		Tester tester = new Tester();
		tester.addTests(testSuite);
		tester.setRunMode(RunMode.Standard);
		tester.executeAndSaveRunInMemorySlot("recover1");
		assertEquals(1, Reporter.getReporter().getResults().size());

		Reporter.clear();

		// Recuero el test, agrego otro test suite, pero este no deberia correrse, porque pedi la corrida 1
		TP2.Test passedTest = createPassedTest("passedTest");
		TestSuite testSuite2 = createTestSuite();
		testSuite2.addTest(passedTest);
		tester.setRunMode(RunMode.Recover);
		tester.setRecoveryEntry("recover1");
		tester.execute();
		assertEquals(1, Reporter.getReporter().getResults().size());
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
