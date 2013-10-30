package testSuiteTp.exceptions;

public class EqualsAssertException extends AssertException {

	private static final long serialVersionUID = 1L;
	private String expected;
	private String result;
	
	public EqualsAssertException(String expected, String result){
		this.expected = expected;
		this.result = result;
	}

	public String getMessage() {
		return "Assert exception. Se esperaba <" + this.expected
				+ "> pero se obtuvo <" + this.result + ">";
	}

	public void setExpected(String expected) {
		this.expected = expected;
	}

	public void setResult(String result) {
		this.result = result;
	}

}
