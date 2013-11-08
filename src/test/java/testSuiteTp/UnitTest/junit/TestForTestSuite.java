package testSuiteTp.UnitTest.junit;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import testSuiteTp.TestInterface.TestSuite;
import testSuiteTp.TestInterface.UnitTest;
import testSuiteTp.UnitTest.UnitTest3;
import testSuiteTp.UnitTest.UnitTest7;

public class TestForTestSuite {

	TestSuite testSuite;
	UnitTest test3;
	UnitTest test1;
	
	@Before
	public void begin() {
		testSuite = new TestSuiteForTest1("TestSuite1");
		test3 = new UnitTest3("TestUnit3");
		test1 = new UnitTest7("TestUnit7");
		testSuite.add(test3);
	}

	/**
	 * Verifica que una TestSuite con un unico test corra el test correctamente
	 */
	@Test
	public void oneTestRun() {
		testSuite.run();
		assertTrue(test3.hasPassed());
	}
	
	/**
	 * Verifica que una TestSuite con dos tests corra el test correctamente
	 */
	@Test
	public void twoTestRun() {
		testSuite.add(test1);
		
		testSuite.run();
		assertTrue(test3.hasPassed());
		assertTrue(test1.hasPassed());
	}
	
	/**
	 * Verifica que dos test suites una hija de la otra y cada una con un test, puedan correr correctamente sus tests
	 */
	@Test
	public void twoNestedTestSuites() {
		TestSuite childTestSuite = new TestSuiteForTest1("Child TestSuite");
		childTestSuite.add(test1);
		testSuite.add(childTestSuite);

		testSuite.run();
		
		assertTrue(test3.hasPassed());
		assertTrue(test1.hasPassed());
	}
	
	

}
