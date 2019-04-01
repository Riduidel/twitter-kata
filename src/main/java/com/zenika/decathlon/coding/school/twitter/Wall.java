package com.zenika.decathlon.coding.school.twitter;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.kohsuke.args4j.Argument;

public class Wall implements Command {
	@Argument(index = 0, metaVar = "login", usage="User who wants to post a message") 
	String user;

	@Override
	public void perform(Store store) {
		Logger logger = Outputter.READ.getFormattedOutput();
		List<Message> messages = new ArrayList<>();
		User orCreate = store.getOrCreate(user);
		messages.addAll(orCreate.messages);
		for(User f : orCreate.followed) {
			messages.addAll(f.messages);
		}
		for(Message m : messages) {
			logger.log(Level.INFO, Read.format(m));
		}
	}

}
