package com.pattern;

public class TestBatch {


	public static void main(String[] args) {

		try {
		BatchProcessor batchProcessor=createBatchProcessor(args[0]);
		batchProcessor.batchProcess(args[1]);
		}
		
		catch(ArrayIndexOutOfBoundsException e){
			e.printStackTrace();
		}
	}

	private static BatchProcessor createBatchProcessor(String arg) {
	 if(arg.equals("text")) return new TextBatchProcessor();
	  return null;
	}
	
	
}
