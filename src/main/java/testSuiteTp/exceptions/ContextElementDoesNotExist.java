package testSuiteTp.exceptions;

public class ContextElementDoesNotExist extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public String getMessage(){
		return "El elemento solicitado al contexto no existe";		
	}
}
