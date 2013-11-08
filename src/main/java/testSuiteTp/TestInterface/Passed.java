package testSuiteTp.TestInterface;

public class Passed implements State {

	@Override
	public String getMessage() {
		return "Success";
	}

	@Override
	public ResultEnum getResult() {
		return ResultEnum.OK;
	}

}
