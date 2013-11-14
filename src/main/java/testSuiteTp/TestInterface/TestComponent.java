package testSuiteTp.TestInterface;

public abstract class TestComponent implements XmlRepresentable {
	
	private static final String REG_EXP_NULL = ".*" ;
	
	protected Context context = new Context();
	protected TestSuite ParentTest;
	String testName;

	public void run() {
		Context emptyContext = new Context();
		this.run(emptyContext, REG_EXP_NULL);
	}
	
	public void run(String regExp) {
		Context emptyContext = new Context();
		this.run(emptyContext, regExp );
	}
	
	public void run(Context parentContext) {
		Context emptyContext = new Context();
		this.run(emptyContext, REG_EXP_NULL );
	}
	
	abstract public void run(Context parentContext, String regExp );
	
	abstract public String getXpathNavigatorRepresentation();
	
	public void setUp(Context context){};
	
	public void tearDown(Context context){};
	
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
	
	protected void mergeWithParentContext(Context parentContext) {
		this.context.merge(parentContext);		
	}

	public Context getContext() {
		return this.context;
	}
	
}
