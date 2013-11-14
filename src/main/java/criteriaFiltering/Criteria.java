package criteriaFiltering;


public abstract class Criteria<T> implements Critiziable<T> {

	@Override
	public Critiziable<T> And(Critiziable<T> other) {
		return new AndOp<T>( this , other );
	}

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
