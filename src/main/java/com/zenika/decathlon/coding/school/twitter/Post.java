package com.zenika.decathlon.coding.school.twitter;

import org.kohsuke.args4j.Argument;

public class Post implements Command {
	@Argument String user;
	@Argument String message;

	@Override
	public void perform(Main main) {
		// TODO Auto-generated method stub
		
	}

}
