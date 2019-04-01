package com.zenika.decathlon.coding.school.twitter;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class UnfollowTest {

	@Test
	void test() {
		Store store = new Store();
		MainTestHelper.parse("follow Cédric Farida").perform(store);
		MainTestHelper.parse("unfollow Cédric Farida").perform(store);
		Assertions.assertThat(store.getOrCreate("Cédric").followed)
			.doesNotContain(store.getOrCreate("Farida"));
	}

}
