package testSuiteTp.UnitTest.junit;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import tags.TagCriteria;
import testSuiteTp.TestInterface.ResultEnum;
import testSuiteTp.TestInterface.TestSuite;
import testSuiteTp.TestInterface.UnitTest;
import testSuiteTp.UnitTest.DefaultTestSuite;
import testSuiteTp.UnitTest.UnitTest2;


public class SimpleTagTesting {
	private TestSuite ts;
	private UnitTest testa;
	private TagCriteria cTc;
	
	@Before
	public void setUp(){
		ts = new DefaultTestSuite("TestSuiteTom");
		
		testa = new UnitTest2("HOLAxxx");
		
		testa.addTag("SIMPLE");
		
		ts.add(testa);
		
		cTc = new TagCriteria("SIMPLE");
	}
	
	@Test
	public void Test1(){
		ts.run( cTc );
		assertEquals( testa.getResult() , ResultEnum.FAIL );
	}
}
