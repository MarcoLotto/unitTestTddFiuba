package testSuiteTp.TestInterface;

public class Passed implements State {

	@Override
	public String getMessage() {
		return "Successful";
	}

	@Override
	public int getResult() {
		return 1;
	}

}
