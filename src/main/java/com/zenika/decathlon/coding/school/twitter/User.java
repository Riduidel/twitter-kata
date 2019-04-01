package com.zenika.decathlon.coding.school.twitter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class User implements Comparable<User> {

	public final String login;
	public List<Message> messages = new ArrayList<>();
	public Set<User> followed = new TreeSet<>();

	public User(String user) {
		this.login = user;
	}

	public void addMessage(String text) {
		messages.add(new Message(text));
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("User [login=");
		builder.append(login);
		builder.append(", messages=");
		builder.append(messages.size());
		builder.append(", followed=");
		builder.append(followed.size());
		builder.append("]");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		return Objects.hash(login);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(login, other.login);
	}

	public void follow(User orCreate) {
		followed.add(orCreate);
	}

	@Override
	public int compareTo(User o) {
		return login.compareTo(o.login);
	}

	public void unfollow(User orCreate) {
		followed.remove(orCreate);
	}

}
