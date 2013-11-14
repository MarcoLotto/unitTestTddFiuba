package testSuiteTp.UnitTest;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import testSuiteTp.TestInterface.ResultEnum;
import testSuiteTp.TestInterface.TestSuite;
import testSuiteTp.TestInterface.UnitTest;


public class SimpleTagTesting {
	private TestSuite ts;
	private UnitTest testa;
	
	@Before
	public void setUp(){
		ts = new DefaultTestSuite("TestSuiteTom");
		testa = new UnitTest2("HOLAxxx");
		ts.add(testa);
	}
	
	@Test
	public void Test1(){
		ts.run();
		assertEquals( testa.getResult() , ResultEnum.FAIL );
	}
}
