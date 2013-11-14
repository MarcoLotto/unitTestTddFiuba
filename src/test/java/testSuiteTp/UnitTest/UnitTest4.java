package testSuiteTp.UnitTest;

import testSuiteTp.TestInterface.UnitTest;
import testSuiteTp.exceptions.ContextElementDoesNotExist;

public class UnitTest4 extends UnitTest {

	public UnitTest4(String testName) {
		super(testName);
	}

	/**
	 * Prueba que no se tenga acceso a una variable de una suite que no esta por encima de este
	 * test en el arbol de testSuites
	 *  
	 * @Override
	 */
	protected void runThis() {
		try{
			String suiteVariable2 = (String) context.getElement("suiteVariable2");
			assertTrue(false);
		}
		catch(ContextElementDoesNotExist e){
			
		}
	}

}
