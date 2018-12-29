package com.pattern;

import java.io.File;
import java.util.List;

public class TextParser implements Parser {

	public TextParser(File file) {
		
		System.out.println("Creating TEXT PARSER");
	}
	@Override
	public List<Records> parser() {
		System.out.println("Creating record list text parser");
		return null;
	}



}
