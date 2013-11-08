package testSuiteTp.logguer;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import testSuiteTp.TestInterface.UnitTest;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class TestLog {
	
	private String PathFromRoot;
	private Map<String, UnitTest> testsMaked = new HashMap<String, UnitTest>();
	
	public TestLog(){
	}
	
	public void setPath(String path){
		this.PathFromRoot = path;
	}
	
	public void processResults(List<UnitTest> totalTests){
		this.testsMaked.clear();
		for (UnitTest test : totalTests) {
			testsMaked.put(test.getName(), test);
		}
	}
	
	public void showResults() {	
		PrintStream console = System.out;

		File file = new File("TestLogs.txt");
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(file,true);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		PrintStream ps = new PrintStream(fos);
		System.setOut(ps);
		
		Collection<UnitTest> testsRealized = this.testsMaked.values(); 
		System.out.println("Tests for :"+this.PathFromRoot + " #: " + testsRealized.size() );
		for (UnitTest test : testsRealized) {
			String message = "[" + test.getResult()+"] "+ test.getName() + ": " + test.getMessage();
			System.out.println("	" + message);
		}
		System.out.println("");
		System.setOut(console);
	}	
}
