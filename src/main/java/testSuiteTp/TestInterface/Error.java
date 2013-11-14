package testSuiteTp.TestInterface;

public class Error implements State {
	private Exception exception;

	public Error(Exception exception) {
		this.exception = exception;
	}

	public String getMessage() {
		return this.exception.getMessage();
	}

	public ResultEnum getResult() {
		return ResultEnum.ERROR;
	}

}
