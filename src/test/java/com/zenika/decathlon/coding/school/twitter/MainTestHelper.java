package com.zenika.decathlon.coding.school.twitter;

import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;

public class MainTestHelper {

	public static Command parse(String string) {
		Main main = new Main();
		CmdLineParser parser = new CmdLineParser(main);
		try {
			parser.parseArgument(string.split(" "));
			return main.command;
		} catch(CmdLineException e) {
			throw new RuntimeException(e);
		}
		
	}
	
}
