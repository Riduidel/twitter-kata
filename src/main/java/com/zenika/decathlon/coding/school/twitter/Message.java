package com.zenika.decathlon.coding.school.twitter;

import java.util.Objects;

public class Message {
	public final String text;

	public Message(String text) {
		super();
		this.text = text;
	}

	@Override
	public int hashCode() {
		return Objects.hash(text);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Message other = (Message) obj;
		return Objects.equals(text, other.text);
	}
}
