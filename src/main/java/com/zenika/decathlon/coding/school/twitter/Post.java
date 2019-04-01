package com.zenika.decathlon.coding.school.twitter;

import java.util.List;

import org.kohsuke.args4j.Argument;

public class Post implements Command {
	@Argument(index = 0, metaVar = "login", usage="User who wants to post a message") 
	public String user;
	@Argument(index = 1, metaVar = "message", usage="Message") 
	public List<String> message;

	@Override
	public void perform(Store store) {
		store.getOrCreate(user).addMessage(String.join(" ", message));
	}

}
