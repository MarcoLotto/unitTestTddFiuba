package testSuiteTp.UnitTest.junit;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import testSuiteTp.TestInterface.TestSuite;
import testSuiteTp.TestInterface.UnitTest;
import testSuiteTp.UnitTest.UnitTestForTesting1;
import testSuiteTp.UnitTest.UnitTestForTesting2;
import testSuiteTp.UnitTest.UnitTestForTesting3;

public class TestForTestSuite {

	TestSuite testSuite;
	UnitTest test3;
	
	@Before
	public void begin() {
		testSuite = new TestSuiteForTest1("TestSuite1");
		test3 = new UnitTestForTesting3("TestUnit3");
		testSuite.add(test3);
	}

	@Test
	public void oneTestRun() {
		testSuite.run();
		assertTrue(test3.hasPassed());
	}
	
	@Test
	public void twoTestRun() {
		UnitTest test1 = new UnitTestForTesting1("TestUnit1");
		testSuite.add(test1);
		
		testSuite.run();
		assertTrue(test3.hasPassed());
		assertFalse(test1.hasPassed());
	}

}
