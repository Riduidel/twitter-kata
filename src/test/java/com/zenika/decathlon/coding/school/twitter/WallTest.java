package com.zenika.decathlon.coding.school.twitter;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Handler;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class WallTest {

	@Test
	void I_can_read_one_message() {
		Logger logger = Outputter.READ.getFormattedOutput();
		List<LogRecord> records = new ArrayList<>();
		Handler handler = new Handler() {

			@Override
			public void publish(LogRecord record) {
				records.add(record);
			}

			@Override
			public void flush() {}

			@Override
			public void close() throws SecurityException {}
			
		};
		logger.addHandler(handler);
		
		Store store = new Store();
		MainTestHelper.parse("post Cédric message").perform(store);
		MainTestHelper.parse("post Guillaume autre").perform(store);
		MainTestHelper.parse("follow Cédric Guillaume").perform(store);
		MainTestHelper.parse("wall Cédric").perform(store);
		assertThat(records).size().isEqualTo(2);
		assertThat(records).extracting((l) -> l.getMessage()).contains("message", "autre");
	}

}
