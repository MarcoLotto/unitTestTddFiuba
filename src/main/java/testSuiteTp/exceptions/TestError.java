package testSuiteTp.exceptions;

public class TestError extends Error{

	private static final long serialVersionUID = 1L;
	
	String ErrorMsg;
	
	public TestError(String NameFail){
		this.ErrorMsg = "Error: 2 Tests con el mismo nombre!: " + NameFail;
	}
	
	
	public String getMessage() {
		return this.ErrorMsg;
	}

}
