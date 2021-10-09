package com.example.app.address;

import javax.persistence.*;

import com.example.app.client.Client;

@Entity
@Table
public class Address {
	@Id
	@SequenceGenerator(name = "address_sequence", sequenceName = "address_sequence", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "address_sequence")
	private Long id;
	private String country;
	private String city;
	private String details;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "client_id", nullable = false)
	private Client client;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

}
