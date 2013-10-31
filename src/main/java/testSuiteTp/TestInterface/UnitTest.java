package testSuiteTp.TestInterface;

import testSuiteTp.exceptions.AssertException;
import testSuiteTp.exceptions.EqualsAssertException;

public abstract class UnitTest {

	private UnitTestState state = new UnitTestState();
	private String testName;
	
	protected UnitTest( String testName){ 
		this.testName = testName ;
		}

	//Esta es la funcion con la cual se corre el test
	public void run(){
		try{
			runThis();
			state.setAsPassed();
			}
		catch(Exception e){
			state.setAsFailed(e);
			}
		}
	
	//Esto es lo que el cliente debe implementar. El cuerpo del Test.
	protected abstract void runThis();

	public void assertTrue(boolean result) {
		if (!result) { throw new AssertException(); }
	}

	public void assertFalse(boolean result) {
		assertTrue(!result);
	}

	public void assertEquals(Object expected, Object result) {
		if (!expected.equals(result)) {
			throw new EqualsAssertException(expected.toString(), result.toString());
		}
	}

	public UnitTestState getState() {
		return state;
	}

	public String getName() {
		return testName;
	}
}
