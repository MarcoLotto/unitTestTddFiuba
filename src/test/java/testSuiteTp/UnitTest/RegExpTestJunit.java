package testSuiteTp.UnitTest;

import org.junit.Before;
import org.junit.Test;

import testSuiteTp.TestInterface.TestSuite;


public class RegExpTestJunit {
	private TestSuite ts;
	
	@Before
	public void setear(){
		ts = new RegExpTest("TestSuiteTom");		
	}
	
	@Test
	public void Test1(){	
		ts.run(".*HOLA.*");
	}

}
