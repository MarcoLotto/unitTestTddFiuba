package testSuiteTp.TestInterface;

import testSuiteTp.exceptions.AssertException;
import testSuiteTp.exceptions.EqualsAssertException;

public abstract class UnitTest {

	private UnitTestState state = new UnitTestState();

	public abstract void run();

	public abstract String getName();

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

	public UnitTestState getState() {
		return state;
	}
}
