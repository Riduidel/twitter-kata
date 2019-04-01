package com.zenika.decathlon.coding.school.twitter;

import org.kohsuke.args4j.Argument;

public class Follow implements Command {
	@Argument(index = 0, metaVar = "follower", usage = "login of the follower")
	String follower;
	@Argument(index = 1, metaVar = "followed", usage = "login of the followed")
	String followed;

	@Override
	public void perform(Store store) {
		store.getOrCreate(follower).follow(store.getOrCreate(followed));
	}

}
