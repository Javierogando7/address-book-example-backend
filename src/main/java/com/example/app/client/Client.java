package com.example.app.client;

import javax.persistence.*;

@Entity
@Table
public class Client {
	@Id
	@SequenceGenerator(name = "client_sequence", sequenceName = "client_sequence", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "client_sequence")
	private Long id;
	
	private String name;
	
	private String phoneNumber;

	public Client() {
	};

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
}
