package criteriaFiltering;


public abstract class Criteria<T> implements Critiziable<T> {

	@Override
	public Critiziable<T> And(Critiziable<T> other) {
		return new AndOp<T>( this , other );
	}
	
	// This must be overridden by the Client that wants to create a criteria to use as filter !
	@Override
	public abstract boolean IsSatisfiedBy(T candidate);

	@Override
	public Critiziable<T> Not() {
		return new NotOp<T>( this );
	}

	@Override
	public Critiziable<T> Or(Critiziable<T> other) {
		return new OrOp<T>(this, other);
	}

}
