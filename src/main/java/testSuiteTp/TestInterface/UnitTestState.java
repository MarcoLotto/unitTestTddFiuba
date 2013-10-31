package testSuiteTp.TestInterface;
public class UnitTestState {

	private boolean passed = false;
	private Exception failException;
	
	public boolean isPassed() {
		return passed;
	}

	public void setAsPassed() {
		this.passed = true;
		this.failException = null;
	}

	public void setAsFailed(Exception exception) {
		this.failException = exception;
		this.passed = false;
	}

	public String getExceptionMessage() {
		if ( passed == false ){
			return failException.getMessage();
		}
		return "";
	}
}
