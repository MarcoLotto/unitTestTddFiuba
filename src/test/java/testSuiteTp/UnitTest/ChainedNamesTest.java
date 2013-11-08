package testSuiteTp.UnitTest;


import org.junit.Before;
import org.junit.Test;

import testSuiteTp.TestInterface.TestSuite;
import testSuiteTp.TestInterface.UnitTest;

public class ChainedNamesTest {
	private TestSuite ts1;
	private TestSuite ts2;
	private TestSuite ts3;
	private TestSuite ts4;
	private TestSuite ts5;
	private TestSuite ts6;
	private UnitTest ut1;
	private UnitTest ut2;
	@Before
	public void setUp(){
		ts1 = new DefaultTestSuite("A");
		ts2 = new DefaultTestSuite("B");
		ts3 = new DefaultTestSuite("C");
		ts4 = new DefaultTestSuite("D");
		ts5 = new DefaultTestSuite("E1");
		ts6 = new DefaultTestSuite("E2");
		ut1 = new UnitTest9("testCaseDeE1");
		ut2 = new UnitTest8("testCaseDeE2");
		
		ts5.add(ut1);
		ts6.add(ut2);
		
		ts1.add(ts2);
		ts2.add(ts3);
		ts3.add(ts4);
		ts4.add(ts5);
		ts4.add(ts6);
	}
	@Test
	public void LongNameTest(){
		ts1.run();				
	}

}
