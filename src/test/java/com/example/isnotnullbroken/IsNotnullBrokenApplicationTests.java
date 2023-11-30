package com.example.isnotnullbroken;

import static com.example.isnotnullbroken.IsNotnullBrokenApplicationTests.*;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest(
	properties = {
		"spring.jpa.properties.jakarta.persistence.schema-generation.database.action=create",
		"spring.jpa.properties.jakarta.persistence.schema-generation.scripts.action=create",
		"spring.jpa.properties.jakarta.persistence.schema-generation.scripts.action=create",
		"spring.jpa.properties.jakarta.persistence.schema-generation.scripts.create-target=" + OUTPUT_FILE,
		"spring.jpa.properties.jakarta.persistence.schema-generation.scripts.create-source=metadata",
		"spring.jpa.properties.hibernate.format_sql=true",
	})
class IsNotnullBrokenApplicationTests {

	static final String OUTPUT_FILE = "dump.txt";

	static {
		try {
			try (FileWriter fileWriter = new FileWriter(OUTPUT_FILE, false)) {
				//clear file contents
			}

			Assertions.assertThat(Files.readAllLines(Path.of(OUTPUT_FILE))).isEmpty();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	@Test
	void checkThatNameFieldHasNotNullConstraint() throws IOException {
		Assertions.assertThat(Files.readString(Path.of(OUTPUT_FILE)))
			.contains("name varchar(255) not null");
	}

}
