package com.example.isnotnullbroken;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

@Entity
public class TestEntity {

	@Id
	private Long id;

	@NotNull
	private String name;

}
