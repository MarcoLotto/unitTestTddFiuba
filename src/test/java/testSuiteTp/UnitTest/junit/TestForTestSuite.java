package testSuiteTp.UnitTest.junit;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import testSuiteTp.TestInterface.TestSuite;
import testSuiteTp.TestInterface.UnitTest;
import testSuiteTp.UnitTest.UnitTest3;
import testSuiteTp.UnitTest.UnitTest7;
import testSuiteTp.exceptions.TestError;

public class TestForTestSuite {

	TestSuite testSuite;
	UnitTest test3;
	UnitTest test2;
	UnitTest test1;
	
	@Before
	public void begin() {
		testSuite = new TestSuiteForTest1("TestSuite1");
		test3 = new UnitTest3("TestUnit3");
		test2 = new UnitTest7("TestUnit7_Bis");
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
	
	/**
	 * Verifica que dos test suites una hija de la otra, la hija con dos tests, y que puedan correr correctamente sus tests
	 */
	@Test
	public void multipleTestsInNestedTestSuites() {
		TestSuite childTestSuite = new TestSuiteForTest1("Child TestSuite");
		childTestSuite.add(test1);
		childTestSuite.add(test2);
		testSuite.add(childTestSuite);

		testSuite.run();
		
		assertTrue(test3.hasPassed());
		assertTrue(test2.hasPassed());
		assertTrue(test1.hasPassed());
	}
	
	/**
	 * Comprueba que no se puedan agregar a una test suite dos UnitTest con el mismo nombre
	 */
	@Test
	public void sameUnitTestNamesNotAllowed() {
		UnitTest test1Repetido = new UnitTest7("TestUnit7");
		testSuite.add(test1);
		try{
			testSuite.add(test1Repetido);
			fail();
		}
		catch(TestError e){
		}
	}
	
	/**
	 * Comprueba que no se puedan agregar a una test suite dos TestSuite con el mismo nombre
	 */
	@Test
	public void sameTestSuitesNamesNotAllowed() {
		TestSuite testSuiteA = new TestSuiteForTest1("Child TestSuite");
		TestSuite testSuiteB = new TestSuiteForTest1("Child TestSuite");
		
		testSuite.add(testSuiteA);
		try{
			testSuite.add(testSuiteB);
			fail();
		}
		catch(TestError e){
		}
	}
}
