package testSuiteTp.logguer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import testSuiteTp.TestInterface.TestSuite;
import testSuiteTp.TestInterface.UnitTest;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;

public abstract class TestLog {
	
	private int passedCount;
	private int totalTests;
	protected String pathFromRoot;
	protected TestSuite owner;
	
	public void setPath(String path){
		this.pathFromRoot = path;
	}
			
	public void reset(){
		this.passedCount = 0;
		this.totalTests = 0;		
	}
	
	/**
	 * Imprime el ultimo test realizado
	 */
	public void logResult(UnitTest test) {
		String message = "		[" + test.getResult()+"] "+ test.getName() + ": " + test.getMessage();
		this.showMessage(message  + "\n");
			
		if(test.hasPassed()){
			this.passedCount++;
		}
			this.totalTests++;			
	}			

	/**
	 * Inicia un muestreo del logguer
	 * @param testSuiteName
	 */
	public void openEdition(TestSuite testSuite) {
		//Solo puede abrir la edicion aquel test suite que sea el dueño del log
		if(testSuite.equals(owner)){
			this.processOpenEdition();	
		}		
	}

	/**
	 * Finaliza un muestreo del logguer
	 */
	public void closeEdition(TestSuite testSuite) {
		//Solo puede cerrar la edicion aquel test suite que sea el dueño del log
		if(testSuite.equals(owner)){
			this.processCloseEdition();
		}
	}	

	public void setOwner(TestSuite owner) {
		this.owner = owner;
	}

	protected abstract void showMessage(String message);

	protected abstract void processOpenEdition();

	protected abstract void processCloseEdition();
	
	private String getCloseMessage(String suiteName) {
		return suiteName + " finalized - Passed tests: " + this.passedCount + "/" + this.totalTests + "\n";
	}
	
	private String getHeaderMessage(String testSuiteName) {
		return "Tests for : " + testSuiteName + "\n";
	}

	public void logSuiteHeader(String suiteName) {
		this.showMessage(this.getHeaderMessage(suiteName));				
	}

	public void logSuiteClose(String suiteName) {
		this.showMessage(this.getCloseMessage(suiteName));
	}	
}
