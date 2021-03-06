package com.zenika.decathlon.coding.school.twitter;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import org.kohsuke.args4j.Argument;

public class Read implements Command {
	@Argument(index = 0, metaVar = "login", usage="User who wants to post a message") 
	String user;

	@Override
	public void perform(Store store) {
		Logger logger = Outputter.READ.getFormattedOutput();
		List<Message> messages = new ArrayList<>();
		User orCreate = store.getOrCreate(user);
		messages.addAll(orCreate.messages);
		for(Message m : messages) {
			logger.log(Level.INFO, format(m));
		}
	}

	public static String format(Message m) {
		return m.text;
	}

}
