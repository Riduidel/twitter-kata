package com.zenika.decathlon.coding.school.twitter;

import static com.zenika.decathlon.coding.school.twitter.MainTestHelper.parse;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class PostTest {

	@Test
	void I_can_post_a_message() {
		Store store = new Store();
		parse("post Cédric message").perform(store);
		assertThat(store.users).containsKey("Cédric");
		assertThat(store.users.get("Cédric").messages).contains(new Message("message"));
	}


	@Test
	void I_can_post_two_messages() {
		Store store = new Store();
		parse("post Cédric premier message").perform(store);
		parse("post Cédric deuxième message").perform(store);
		assertThat(store.users).containsKey("Cédric");
		assertThat(store.users.get("Cédric").messages)
			.containsExactly(
					new Message("premier message"),
					new Message("deuxième message"));
	}
}
