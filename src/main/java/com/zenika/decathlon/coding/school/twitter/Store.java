package com.zenika.decathlon.coding.school.twitter;

import java.util.Map;
import java.util.TreeMap;

public class Store {
	Map<String, User> users = new TreeMap<>();

	public User getOrCreate(String user) {
		if(!users.containsKey(user)) {
			users.put(user, new User(user));
		}
		return users.get(user);
	}
}
