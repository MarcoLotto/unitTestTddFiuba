package testSuiteTp.UnitTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import testSuiteTp.TestInterface.Context;
import testSuiteTp.TestInterface.TestSuite;
import testSuiteTp.TestInterface.UnitTest;

public class TestingUnitTest {
	UnitTest test1;
	
	@Before
	public void setUp(){
		test1 = new UnitTestForTesting1("Test1");	
	}

	@Test
	public void testMustPass1() {
		Context context = new Context();
		context.setElement("suiteVariable1", "Chau", test1);
		test1.setUp(context);
		test1.run(context, ".*");
		assertTrue(test1.hasPassed());
	}

	@Test
	public void testMustPass2() {
		UnitTest test = new UnitTestForTesting3("Test3");
		test.run();
		assertTrue(test.hasPassed());
	}

	@Test
	public void testMustFail() {
		UnitTest test = new UnitTestForTesting2("Test2");
		test.run();
		assertFalse(test.hasPassed());
	}

}
