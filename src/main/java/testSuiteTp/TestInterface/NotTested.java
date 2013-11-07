package testSuiteTp.TestInterface;

public class NotTested implements State {

	@Override
	public String getMessage() {
		return "[Not Tested]";
	}

	@Override
	public ResultEnum getResult() {
		return ResultEnum.NOTTESTED;
	}

}
