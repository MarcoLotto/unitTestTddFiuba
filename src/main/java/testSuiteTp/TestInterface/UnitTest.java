package testSuiteTp.TestInterface;


import criteriaFiltering.Criteria;

import java.util.Calendar;

import testSuiteTp.exceptions.AssertException;
import testSuiteTp.exceptions.EqualsAssertException;

public abstract class UnitTest extends TestComponent {

	private UnitTestState state = new UnitTestState();
	private int runTime;

	public UnitTest(String testName) {
		this.testName = testName;
	}

	/**
	 * Este es el metodo con el que se corre el test
	 */
	@Override
	public void run(Context parentContext, String regExp,Criteria<UnitTest> criteria) {
		boolean regexp = this.getName().matches(regExp);
		boolean crit = criteria.IsSatisfiedBy(this);
		if ( regexp && crit ){
			    
			this.mergeWithParentContext(parentContext);
			this.setUp(this.context);
			try {
				this.beginTimeTest();
				this.runThis();
				state.setAsPassed();
			} 
			catch (AssertException e) {
				state.setAsFailed(e);
			}
			catch (Exception e) {
				state.setAsError(e);
			}
			finally{
				this.endTimeTest();
			}
		}
	}

	private void endTimeTest() {
		this.runTime = this.getCurrentTimeInMilliseconds() - this.runTime;		
	}

	private void beginTimeTest() {
		this.runTime = this.getCurrentTimeInMilliseconds();
	}
	
	private int getCurrentTimeInMilliseconds(){
		return (int) Calendar.getInstance().getTimeInMillis();
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
	
	public int getRunTime() {
		return runTime;
	}

	public String getXpathNavigatorRepresentation(){
		String newLine = System.getProperty("line.separator");
		
		String representation = "";
		representation += "<testcase" + " name=\""+ this.getName() + "\" status=\""+ this.getResult() 
				+ "\">" + newLine;
		
		if(this.state.getResult() == ResultEnum.ERROR){
			representation += "<error>" + newLine;
			representation += "<message>" + this.getMessage() + "</message>" + newLine;	
			representation += "</error>" + newLine;			
		}
		else if(this.state.getResult() == ResultEnum.FAIL){
			representation += "<failure>" + newLine;
			representation += "<message>" + this.getMessage() + "</message>" + newLine;	
			representation += "</failure>" + newLine;			
		}
		representation += "<system-out>" + this.getMessage() + "</system-out>";
		
		
		representation += "</testcase>" + newLine;
		return representation;
	}

	}
