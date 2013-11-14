package testSuiteTp.TestInterface;

public class Passed implements State {

	public String getMessage() {
		return "Success";
	}

	public ResultEnum getResult() {
		return ResultEnum.OK;
	}

}
