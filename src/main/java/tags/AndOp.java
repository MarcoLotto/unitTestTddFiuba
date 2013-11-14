package tags;


public class AndOp<Y> extends Criteria<Y> {
    private Critiziable<Y> One;
    private Critiziable<Y> Other;

    public AndOp( Critiziable<Y> x, Critiziable<Y> other2) 
    {
        this.One =  x;
        this.Other = other2;
    }

    public boolean IsSatisfiedBy(Y candidate) 
    {
    	boolean firstCondition = this.One.IsSatisfiedBy(candidate);
    	boolean secondCondition = this.Other.IsSatisfiedBy(candidate);
        return ( firstCondition && secondCondition );
    }
}
