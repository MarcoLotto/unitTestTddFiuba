package testSuiteTp.UnitTest.junit;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import testSuiteTp.TestInterface.ResultEnum;
import testSuiteTp.TestInterface.TestSuite;
import testSuiteTp.TestInterface.UnitTest;
import testSuiteTp.UnitTest.DefaultTestSuite;
import testSuiteTp.UnitTest.UnitTest2;
import testSuiteTp.UnitTest.UnitTest4;
import testSuiteTp.UnitTest.UnitTest7;
import testSuiteTp.UnitTest.UnitTest8;
import testSuiteTp.UnitTest.UnitTest9;


public class RegExpTestJunit {
	private TestSuite ts;
	private TestSuite tsJunior;
	private UnitTest testa;
	private UnitTest testb;
	private UnitTest testc;
	private UnitTest testd;
	private UnitTest teste;
	private UnitTest testZ;
	@Before
	public void setUp(){
		ts = new DefaultTestSuite("TestSuiteTom");
		tsJunior = new DefaultTestSuite("TestSuiteJunior");
		
		testa = new UnitTest2("HOLAxxx");
		testb = new UnitTest9("xxxHOLAxxx") ;
		testc = new UnitTest8("xxxxxxxchauxxxxx");
		testd = new UnitTest4("test4");
		teste = new UnitTest7("xHxOLA");
		
		testZ = new UnitTest9("xHOLAxTestZ");
		
		tsJunior.add(testZ);
		
		ts.add(testa);
		ts.add(testb);
		ts.add(testc);
		ts.add(tsJunior);
		ts.add(testd);
		ts.add(teste);
	}
	
	@Test
	public void Test1(){
		ts.run(".*HOLA.*");
		assertEquals( testa.getResult() , ResultEnum.FAIL );
		assertEquals( testb.getResult() , ResultEnum.OK );
		assertEquals( testc.getResult() , ResultEnum.NOTTESTED );
		assertEquals( testd.getResult() , ResultEnum.NOTTESTED );
		assertEquals( teste.getResult() , ResultEnum.NOTTESTED );
		assertEquals ( testZ.getResult() , ResultEnum.OK );
	}
	@Test
	public void Test2(){
		ts.run(".*chau.*");
		assertEquals( testa.getResult() , ResultEnum.NOTTESTED );
		assertEquals( testb.getResult() , ResultEnum.NOTTESTED);
		assertEquals( testc.getResult() , ResultEnum.OK );
		assertEquals( testd.getResult() , ResultEnum.NOTTESTED );
		assertEquals( teste.getResult() , ResultEnum.NOTTESTED );
		assertEquals ( testZ.getResult() , ResultEnum.NOTTESTED );
	}
	@Test
	public void Test3(){
		ts.run(".*x.*");
		assertEquals( testa.getResult() , ResultEnum.FAIL );
		assertEquals( testb.getResult() , ResultEnum.OK);
		assertEquals( testc.getResult() , ResultEnum.OK );
		assertEquals( testd.getResult() , ResultEnum.NOTTESTED );
		assertEquals( teste.getResult() , ResultEnum.OK );
		assertEquals ( testZ.getResult() , ResultEnum.OK );
	}

}
