package testSuiteTp.UnitTest;

import testSuiteTp.TestInterface.Context;
import testSuiteTp.TestInterface.UnitTest;

public class UnitTest1 extends UnitTest{

	public UnitTest1(String testName) {
		super(testName);
	}
	
	@Override
	public void setUp(Context cont){
		cont.setElement("localVariable1", "Hola", this);
	}

	@Override
	public void runThis() {
		String localVariable1 = (String) context.getElement("localVariable1");
		String suiteVariable1 = (String) context.getElement("suiteVariable1");
		
		assertEquals("Hola", localVariable1);
		assertTrue(1==1);
		assertEquals("Chau", suiteVariable1);
		assertFalse(suiteVariable1.equals(localVariable1) );
	}

}
