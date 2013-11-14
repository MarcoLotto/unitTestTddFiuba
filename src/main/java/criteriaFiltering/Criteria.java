package criteriaFiltering;


public abstract class Criteria<T> implements Critiziable<T> {

	public Critiziable<T> And(Critiziable<T> other) {
		return new AndOp<T>( this , other );
	}
	
	// Cada criterio debe sobreescribir esto
	@Override
	public abstract boolean IsSatisfiedBy(T candidate);

	public Critiziable<T> Not() {
		return new NotOp<T>( this );
	}

	public Critiziable<T> Or(Critiziable<T> other) {
		return new OrOp<T>(this, other);
	}

}
