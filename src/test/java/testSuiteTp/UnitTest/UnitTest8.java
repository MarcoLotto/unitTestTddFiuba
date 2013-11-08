package testSuiteTp.UnitTest;

import testSuiteTp.TestInterface.UnitTest;

public class UnitTest8 extends UnitTest{

	public UnitTest8(String testName) {
		super(testName);
	}

	@Override
	protected void runThis() {
		this.assertEquals( 5 , 5 );
		this.assertEquals( 0 , 0 );
		this.assertFalse( "124343" == "hola");
	}
	

}
