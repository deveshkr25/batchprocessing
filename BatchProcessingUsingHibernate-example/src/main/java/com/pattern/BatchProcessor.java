package com.pattern;

import java.io.File;
import java.util.List;

public abstract class BatchProcessor {

	public final void batchProcess(String fileName){
		File file=openFile(fileName);
		
		Parser parser=null;
		List<Records> records=parser.parser();
		process(records);
		writeSummary();
		closeFile(file);
		parser=createParser(file);//factory method
		
	/*	if(format.equals("txt")){
			parser=new TextParser(file);
			
		}
		else if(format.equals("xml")){
			parser=new XMLParser(file);
			
		}*/
		
	
	}
	
	public abstract Parser createParser(File file);
	private File openFile(String fileName) {

		System.out.println("Open file");
		return null;
	}

	private void writeSummary() {
		System.out.println("writeSummary");
		
	}
	private void process(List<Records> records) {
		System.out.println("Processing Records....");
		
		
	}


	private void closeFile(File file) {
		
		System.out.println("Close file");
		
	}
}
