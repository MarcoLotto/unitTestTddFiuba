package testSuiteTp.UnitTest;

import testSuiteTp.TestInterface.Context;
import testSuiteTp.TestInterface.UnitTest;

public class UnitTestForTesting2 extends UnitTest{

	UnitTestForTesting2(String testName) {
		super(testName);
	}
	
	@Override
	public void setUp(Context context){
		
	}

	@Override
	public void runThis(Context context) {
		assertEquals("Chau", "Hola");
	}
}
