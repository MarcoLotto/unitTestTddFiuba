package TP2;

/** Assert
 * Esta clase tiene como responsabilidad hacer las pruebas sobre los datos que
 * se envian y agregar los resultados (correctos o incorrectos) al reporte.
 **/

public class Assert {

	public static void isTrue(boolean toTest, String testName) {
		if (!toTest) {
			throw new AssertFailedException("Expected 'true', but was 'false'");
		}
	}

	public static void AreEquals(Object object1, Object object2, String testName) {
		if (!object1.equals(object2)) {
			throw new AssertFailedException("Expected '" + object1 +"' but was '" + object2 +"'");
		}
	}
	
	public static void Fail(String testName) {
		throw new AssertFailedException("Test failed by method Fail");
	}

}