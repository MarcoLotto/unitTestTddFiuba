package testSuiteTp.UnitTest.junit;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import testSuiteTp.TestInterface.Context;
import testSuiteTp.TestInterface.TestSuite;
import testSuiteTp.TestInterface.UnitTest;
import testSuiteTp.UnitTest.TestSuiteForTesting1;
import testSuiteTp.UnitTest.TestSuiteForTesting2;
import testSuiteTp.UnitTest.UnitTest3;
import testSuiteTp.UnitTest.UnitTest7;
import testSuiteTp.exceptions.ContextElementDoesNotExist;

public class TestForContext {

	TestSuite testSuite1;
	TestSuite testSuite2;
	UnitTest test1;

	@Before
	public void begin() {
		testSuite1 = new TestSuiteForTesting1("TestSuite1");
		testSuite2 = new TestSuiteForTesting2("TestSuite2");
		test1 = new UnitTest7("TestUnit7");
	}

	/**
	 * Se prueba un ambiente con contextos con un unico TestSuite. Si el run()
	 * no lanza excepciones es que termino correctamente
	 */
	@Test
	public void contextInSimpleTestSuites() {
		testSuite2.run();
	}

	/**
	 * Se prueba un ambiente con dos contextos uno padre y uno hijo con un unico
	 * TestSuite. Si el run() no lanza excepciones es que termino correctamente
	 */
	@Test
	public void contextInNestedTestSuites() {
		testSuite1.run();
	}
	
	/**
	 * Se prueba que si yo pido un elemento de un contexto que no existe, lance la excepcion esperada
	 */
	@Test
	public void elementNotFoundInContext() {
		Context context = new Context();
		try{
			context.getElement("NOEXISTE");
			fail();
		}
		catch(ContextElementDoesNotExist e){
		}
	}
	
	/**
	 * Se prueba que si yo declaro un elemento en el contexto, este se cree correctamente
	 */
	@Test
	public void elementCreatedInContext() {
		Context context = new Context();
		context.setElement("AHORA_EXISTE", 10, test1);
		int value = (Integer) context.getElement("AHORA_EXISTE");
		assertEquals(10, value);		
	}

}
