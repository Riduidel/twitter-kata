package com.zenika.decathlon.coding.school.twitter;

import org.kohsuke.args4j.Argument;

public class Unfollow implements Command {
	@Argument(index = 0, metaVar = "follower", usage = "login of the follower")
	String user1;
	@Argument(index = 1, metaVar = "followed", usage = "login of the unfollowed")
	String user2;

	@Override
	public void perform(Store store) {
		store.getOrCreate(user1).unfollow(store.getOrCreate(user2));
	}

}
