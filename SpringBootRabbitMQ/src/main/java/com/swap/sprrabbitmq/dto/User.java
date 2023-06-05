package com.swap.sprrabbitmq.dto;

import lombok.Data;

//dto class for serialization and deserialization

@Data
public class User {

	private int id;
	private String firstName;
	private String lastName;
}
