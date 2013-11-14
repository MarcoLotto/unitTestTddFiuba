package testSuiteTp.TestInterface;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

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
	public void run(Context parentContext, String regExp) {
		if (this.getName().matches(regExp)){
			this.mergeWithParentContext(parentContext);
			this.setUp(this.context);
			try {
				this.runThis();
				state.setAsPassed();
			} 
			catch (AssertException e) {
				state.setAsFailed(e);
			}
			catch (Exception e) {
				state.setAsError(e);
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
	
	
	public String getXpathNavigatorRepresentation(){
		String newLine = System.getProperty("line.separator");
		
		String representation = "";
		representation += "<testcase>" + newLine;
		if(this.state.getResult() == ResultEnum.ERROR){
			representation += "<error>" + newLine;
			representation += "<type>failure error</type>" + newLine;
			representation += "<message>" + this.getMessage() + "</message>" + newLine;	
			representation += "</error>" + newLine;			
		}
		else if(this.state.getResult() == ResultEnum.FAIL){
			representation += "<failure>" + newLine;
			representation += "<type>failure error</type>" + newLine;
			representation += "<message>" + this.getMessage() + "</message>" + newLine;	
			representation += "</failure>" + newLine;			
		}
		representation += "<name>" + this.getName() + "</name>" + newLine;
		representation += "<status>" + this.getResult() + "</status>" + newLine;
		
		representation += "</testcase>" + newLine;
		return representation;
	}

	}
