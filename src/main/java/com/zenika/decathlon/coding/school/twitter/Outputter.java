package com.zenika.decathlon.coding.school.twitter;

import java.util.logging.ConsoleHandler;
import java.util.logging.Logger;

public enum Outputter {
	READ;

	public Logger getFormattedOutput() {
		Logger logger = Logger.getLogger(this.name());
		logger.setUseParentHandlers(false);
		ConsoleHandler console = new ConsoleHandler();
		console.setFormatter(new TwitterFormatter());
		logger.addHandler(console);
		return logger;
	}

}
