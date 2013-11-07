package testSuiteTp.UnitTest;

import org.junit.Test;

import testSuiteTp.TestInterface.TestSuite;


public class RegExpTestJunit {
	
	@Test
	public void Test1(){
		TestSuite ts = new RegExpTest("TestSuiteTom");		
		ts.run(".*HOLA.*");
	}

}
