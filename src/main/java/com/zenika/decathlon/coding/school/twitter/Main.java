package com.zenika.decathlon.coding.school.twitter;

import java.util.logging.Logger;

import org.kohsuke.args4j.Argument;
import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.spi.SubCommand;
import org.kohsuke.args4j.spi.SubCommandHandler;
import org.kohsuke.args4j.spi.SubCommands;

public class Main {
	private static final Logger LOGGER = Logger.getLogger(Main.class.getName());
	public static void main(String[] args) {
		new Main().doMain(args);
	}

    @Argument(required=true,
    		index=0,
    		metaVar="action",
    		usage="subcommand to run",
    		handler=SubCommandHandler.class)
    @SubCommands({
        @SubCommand(name="post", impl=Post.class),
        @SubCommand(name="read", impl=Read.class),
        @SubCommand(name="follow", impl=Follow.class),
        @SubCommand(name="unfollow", impl=Unfollow.class),
        @SubCommand(name="wall", impl=Wall.class)
    })
    Command command;

	private void doMain(String[] args) {
		CmdLineParser parser = new CmdLineParser(this);
		try {
			if(args.length==0)
				throw new CmdLineException("you should give at least one command-line argument !");
			// parse the arguments.
			parser.parseArgument(args);

			Store store = new Store();
			command.perform(store);
		} catch (CmdLineException e) {
			// if there's a problem in the command line,
			// you'll get this exception. this will report
			// an error message.
			System.err.println(e.getMessage());
			// print the list of available options
			parser.printUsage(System.err);
			System.err.println();

			return;
		}
	}
}
