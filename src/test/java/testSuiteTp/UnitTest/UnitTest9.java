package testSuiteTp.UnitTest;

import testSuiteTp.TestInterface.Context;
import testSuiteTp.TestInterface.UnitTest;

public class UnitTest9 extends UnitTest {

	public UnitTest9(String testName) {
		super(testName);
	}

	@Override
	protected void runThis(Context context) {
		this.assertTrue("theENDisHERE" == "theENDisHERE");
	}

}
