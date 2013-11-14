package tags;

public class RegExpOp<T> extends Criteria<T> {
	
	String regExp;
	
	public RegExpOp<T>(String regExp1){
		this.regExp = regExp1;
	}

	@Override
	public boolean IsSatisfiedBy(T candidate) {
		return false;
	}

}
