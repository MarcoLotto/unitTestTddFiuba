package testSuiteTp.TestInterface;

public class NotTested implements State {

	@Override
	public String getMessage() {
		return "Test wasn't run";
	}

	@Override
	public int getResult() {
		return 0;
	}

}
