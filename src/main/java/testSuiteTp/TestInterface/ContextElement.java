package testSuiteTp.TestInterface;

public class ContextElement {

	private TestComponent creatorComponent;
	private Object elementValue;
	private boolean dirty;
	
	public ContextElement(TestComponent creatorComponent){
		this.creatorComponent = creatorComponent;
	}

	public Object getElementValue() {
		if (this.dirty) {
			this.reload();
		}
		return this.elementValue;
	}

	public void setElementValue(Object value) {
		this.elementValue = value;
		this.dirty = false;
	}

	public void setAsDirty() {
		this.dirty = true;
	}

	private void reload() {
		this.creatorComponent.setUp(this.creatorComponent.getContext());
	}
}
