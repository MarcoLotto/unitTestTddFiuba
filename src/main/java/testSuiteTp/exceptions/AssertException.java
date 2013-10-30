package testSuiteTp.exceptions;

public class AssertException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public String getMessage(){
		return "Assert exception";		
	}
}
