package tags;


public class NotOp<T> extends Criteria<T>{
	private Critiziable<T> Wrapped;
    
    public NotOp(Critiziable<T> criteria) {
        Wrapped = criteria;
	}
    
    @Override
    public boolean IsSatisfiedBy(T candidate) 
    {
        return !Wrapped.IsSatisfiedBy(candidate);
    }

}
