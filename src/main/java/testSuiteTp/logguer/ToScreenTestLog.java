package testSuiteTp.logguer;

public class ToScreenTestLog extends TestLog {

	@Override
	protected void showMessage(String message) {
		System.out.print(message);		
	}

	@Override
	protected void processOpenEdition() {
		//Como es salida a pantalla, no hace falta abrir medios
	}

	@Override
	protected void processCloseEdition() {
		//Como es salida a pantalla, no hace falta cerrar medios
	}

}
