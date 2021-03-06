package testSuiteTp.TestInterface;

public class UnitTestState {
	
	State state;
	
	UnitTestState(){
		this.state = new NotTested();
	}

	public void setAsPassed() {
		this.state = new Passed();
	}

	public void setAsFailed(Exception exception) {
		this.state = new Failed(exception);
	}
	
	public void setAsError(Exception exception) {
		this.state = new Error(exception);
	}
	
	public String getMessage(){
		return this.state.getMessage();		
	}
	
	public ResultEnum getResult(){
		return this.state.getResult();		
	}
}
