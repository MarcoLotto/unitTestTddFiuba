package testSuiteTp.TestInterface;

import criteriaFiltering.Criteria;
import testSuiteTp.exceptions.AssertException;
import testSuiteTp.exceptions.EqualsAssertException;

public abstract class UnitTest extends TestComponent {

	private UnitTestState state = new UnitTestState();

	public UnitTest(String testName) {
		this.testName = testName;
	}

	/**
	 * Este es el metodo con el que se corre el test
	 */
	public void run(Context parentContext, String regExp,Criteria<TestComponent> criteria) {
		if (this.getName().matches(regExp)){
			this.mergeWithParentContext(parentContext);
			this.setUp(this.context);
			try {
				this.runThis();
				state.setAsPassed();
			} catch (Exception e) {
				state.setAsFailed(e);
			}
		}
	}

	/**
	 * Esto es lo que el cliente debe implementar. El cuerpo del Test.
	 */
	protected abstract void runThis();

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
			throw new EqualsAssertException(expected.toString(), result.toString());
		}
	}

	public void fail(){
		assertTrue(false);
	}
	
	public ResultEnum getResult() {
		return state.getResult();
	}
	
	public boolean hasPassed(){
		return (state.getResult() == ResultEnum.OK);
	}

	public String getMessage() {
		return state.getMessage();
	}
}
