package tags;


public class OrOp<T> extends Criteria<T> {

    private Critiziable<T> One;
    private Critiziable<T> Other;

    public OrOp(Critiziable<T> x, Critiziable<T> y) 
    {
        this.One = x;
        this.Other = y;
    }
    @Override
    public boolean IsSatisfiedBy(T candidate) 
    {
    	boolean firstCondition = this.One.IsSatisfiedBy(candidate);
    	boolean secondCondition = this.Other.IsSatisfiedBy(candidate);
        return ( firstCondition || secondCondition );
    }

}
