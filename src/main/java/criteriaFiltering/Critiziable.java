package criteriaFiltering;

public interface Critiziable <T> {
	
    boolean IsSatisfiedBy(T candidate);
    Critiziable<T> And(Critiziable<T> other);
    Critiziable<T> Or(Critiziable<T> other);
    Critiziable<T> Not();

}
