package testSuiteTp.logguer;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class ToFileTestLog extends TestLog {
	
	private BufferedWriter writer = null;
	
	@Override
	protected void showMessage(String message) {
		try {
			this.writer.write("	" + message);
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	
	@Override
	protected void processOpenEdition() {
		File file = new File(this.pathFromRoot);
		try {
			this.writer = new BufferedWriter(new FileWriter(file));			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void processCloseEdition() {
		try {
			if(this.writer != null){				
				this.writer.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
