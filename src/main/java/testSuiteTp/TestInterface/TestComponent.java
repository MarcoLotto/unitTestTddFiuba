package testSuiteTp.TestInterface;

public abstract class TestComponent {

	public void run(){};
	
	public void setUp(){};
	
	public void tearDown(){};
	
	protected abstract void addReferenceToParent(TestComponent TestComp);
}
