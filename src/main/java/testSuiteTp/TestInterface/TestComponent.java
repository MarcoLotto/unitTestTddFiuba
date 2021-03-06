package testSuiteTp.TestInterface;

import tags.Taggeable;
import criteriaFiltering.Criteria;
import criteriaFiltering.NullCriteria;


public abstract class TestComponent extends Taggeable implements XmlRepresentable {
	
	private static final String REG_EXP_NULL = ".*" ;
	
	protected Context context = new Context();
	protected TestSuite ParentTest;
	String testName;

	final public void run() {
		Context emptyContext = new Context();
		this.run(emptyContext, REG_EXP_NULL);
	}
	
	final public void run(String regExp) {
		Context emptyContext = new Context();
		this.run(emptyContext, regExp );
	}
	
	final public void run(Context parentContext) {
		this.run(parentContext, REG_EXP_NULL );
	}
	
	final public void run(Criteria<UnitTest> cTc) {
		Context emptyContext = new Context();
		this.run(emptyContext, cTc );
	}
	
	final public void run(Context parentContext,Criteria<UnitTest> ctc){
		this.run(parentContext,REG_EXP_NULL,ctc);
	}
	
	final public void run(Context parentContext, String regExp ){
		this.run(parentContext, regExp, new NullCriteria<UnitTest>() );
	}
	
	abstract public void run(Context parentContext, String regExp, Criteria<UnitTest> criteria);
	
	abstract public String getXpathNavigatorRepresentation();
	
	public void setUp(Context context){};
	
	public void tearDown(Context context){};
	
	final public String getName() {
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

	final public Context getContext() {
		return this.context;
	}
	
}
