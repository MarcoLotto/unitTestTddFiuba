package testSuiteTp.TestInterface;

public abstract class TestComponent {

	protected TestSuite ParentTest;
	String testName;

	public void run(){};
	
	public void setUp(){};
	
	public void tearDown(){};
	
	public String getName() {
		return testName;
	}
	
	protected void addReferenceToParent(TestSuite TestS){
		this.ParentTest = TestS;	
	}
	
	//Hermanos no pueden tener el mismo nombre
	protected boolean itHasTheSameName(TestComponent TC){
		boolean retV = false;
		if ( this.getName() == TC.getName() ){ retV = true; }
		return retV;
	}
	
}
