package testSuiteTp.TestInterface;

public class Error implements State {
	private Exception exception;

	public Error(Exception exception) {
		this.exception = exception;
	}

	@Override
	public String getMessage() {
		return this.exception.getMessage();
	}

	@Override
	public ResultEnum getResult() {
		return ResultEnum.ERROR;
	}

}
