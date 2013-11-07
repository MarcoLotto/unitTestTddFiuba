package testSuiteTp.TestInterface;

public class Failed implements State {
	private Exception exception;

	public Failed(Exception exception) {
		this.exception = exception;
	}

	@Override
	public String getMessage() {
		return this.exception.getMessage();
	}

	@Override
	public ResultEnum getResult() {
		return ResultEnum.FAIL;
	}

}
