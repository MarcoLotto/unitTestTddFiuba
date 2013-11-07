package testSuiteTp.TestInterface;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import testSuiteTp.exceptions.ContextElementDoesNotExist;

public class Context {

	private Map<String, ContextElement> contextElements = new HashMap<String, ContextElement>();

	public Object getElement(String elementName) {
		if (!this.contextElements.containsKey(elementName)) {
			throw new ContextElementDoesNotExist();
		}
		ContextElement contextElement = this.contextElements.get(elementName);
		return contextElement.getElementValue();
	}

	public void setElement(String elementName, Object value,
			TestComponent creatorComponent) {
		ContextElement element = new ContextElement(creatorComponent);
		element.setElementValue(value);
		this.contextElements.put(elementName, element);
	}

	/**
	 * Mergea el contexto actual con otro
	 * 
	 * @param parentContext
	 */
	public void merge(Context otherContext) {
		Set<String> elementsNames = otherContext.getContextElements().keySet();
		for (String elementName : elementsNames) {
			if (!this.contextElements.containsKey(elementName)) {
				ContextElement elementToAdd = otherContext.getContextElements().get(elementName);
				this.contextElements.put(elementName, elementToAdd);
			}
		}
	}

	private Map<String, ContextElement> getContextElements() {
		return this.contextElements;
	}

	/**
	 * Resetea o marca como sucias todas las entradas del contexto. De esta
	 * forma si algun elemento se quiere usar, tendra que recalcularse.
	 */
	public void resetContext() {
		Collection<ContextElement> elements = this.contextElements.values();
		for (ContextElement element : elements) {
			element.setAsDirty();
		}
	}
}
