package testSuiteTp.TestInterface;

public class NotTested implements State {

	public String getMessage() {
		return "[Not Tested]";
	}

	public ResultEnum getResult() {
		return ResultEnum.NOTTESTED;
	}

}
