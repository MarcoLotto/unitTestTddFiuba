package testSuiteTp.TestInterface;

import java.util.HashSet;
import java.util.Set;

public abstract class Taggeable {

	final private Set<String> m = new HashSet< String >();
	
	final public boolean isTaggedWith(String strtag){
		return this.m.contains(strtag);
	}
	
	final public void addTag( String strtag){
		this.m.add(strtag);
	}
	
	final public void removeTag( String strtag){
		this.m.remove(strtag);
	}
}
