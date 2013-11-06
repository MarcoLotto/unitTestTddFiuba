package testSuiteTp.TestInterface;

public abstract class TestComponent {
	
	private static final String REG_EXP_NULL = ".*" ;
	
	protected TestSuite ParentTest;
	String testName;

	public void run() {
		this.run(REG_EXP_NULL);
	}
	
	abstract public void run( String regExp );
	
	public void setUp(){};
	
	public void tearDown(){};
	
	public String getName() {
		return this.testName;
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
