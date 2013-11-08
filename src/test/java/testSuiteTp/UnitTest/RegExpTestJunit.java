package testSuiteTp.UnitTest;

import org.junit.Before;
import org.junit.Test;

import testSuiteTp.TestInterface.TestSuite;
import testSuiteTp.TestInterface.UnitTest;


public class RegExpTestJunit {
	private TestSuite ts;
	private UnitTest testa;
	private UnitTest testb;
	private UnitTest testc;
	private UnitTest testd;
	private UnitTest teste;
	@Before
	public void setear(){
		ts = new RegExpTest("TestSuiteTom");	
		testa = new UnitTest2("HOLAxxx");
		testb = new UnitTest9("xxxHOLAxxx") ;
		testc = new UnitTest8("xxxxxxxchauxxxxx");
		testd = new UnitTest4("test4");
		teste = new UnitTest7("xHxOLA");
		
		ts.add(testa);
		ts.add(testb);
		ts.add(testc);
		ts.add(testd);
		ts.add(teste);
	}
	
	@Test
	public void Test1(){	
		ts.run(".*HOLA.*");
	}

}
