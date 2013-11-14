package criteriaFiltering;


public class NullCriteria<T> extends Criteria<T> {

	@Override
	public boolean IsSatisfiedBy(T candidate) {
		return true;
	}



}
