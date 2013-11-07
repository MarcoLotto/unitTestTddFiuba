package testSuiteTp.TestInterface;

import testSuiteTp.exceptions.AssertException;
import testSuiteTp.exceptions.EqualsAssertException;

public abstract class UnitTest extends TestComponent {

	private UnitTestState state = new UnitTestState();

	protected UnitTest(String testName) {
		this.testName = testName;
	}

	/**
	 * Este es el metodo con el que se corre el test
	 */
	public void run(Context parentContext, String regExp) {
		if (this.getName().matches(regExp)){
			this.mergeWithParentContext(parentContext);
			this.setUp(this.context);
			try {
				this.runThis(this.context);
				state.setAsPassed();
			} catch (Exception e) {
				state.setAsFailed(e);
			}
		}
	}

	/**
	 * Esto es lo que el cliente debe implementar. El cuerpo del Test.
	 * @param context 
	 */
	protected abstract void runThis(Context context);

	public void assertTrue(boolean result) {
		if (!result) {
			throw new AssertException();
		}
	}

	public void assertFalse(boolean result) {
		assertTrue(!result);
	}

	public void assertEquals(Object expected, Object result) {
		if (!expected.equals(result)) {
			throw new EqualsAssertException(expected.toString(), result
					.toString());
		}
	}

	public void fail(){
		assertTrue(false);
	}
	
	public boolean hasPassed() {
		return state.isPassed();
	}

	public String getExceptionMessage() {
		return state.getExceptionMessage();
	}
}
