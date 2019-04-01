package com.zenika.decathlon.coding.school.twitter;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class FollowTest {

	@Test
	void I_can_follow_farida() {
		Store store = new Store();
		MainTestHelper.parse("follow Cédric Farida").perform(store);
		Assertions.assertThat(store.getOrCreate("Cédric").followed)
			.contains(store.getOrCreate("Farida"));
	}

}
