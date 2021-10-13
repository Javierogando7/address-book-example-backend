package com.example.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.app.address.Address;
import com.example.app.client.Client;
import com.example.app.client.IClientService;

@Component
public class UserDataLoader implements CommandLineRunner {
	
	@Autowired
	private IClientService clientService;
	
	@Override
	public void run(String... args) throws Exception {
		this.loadUsers();
	}
	
	private void loadUsers() {
		var newClient = new Client();
		newClient.setName("Juan");
		newClient.setPhoneNumber("000-000-0000");
		
		var newAddress = new Address();
		newAddress.setCity("Santo Domingo");
		newAddress.setCountry("Republica Dominicana");
		newAddress.setDetails("Calle 2");
		
		var newClient2 = new Client();
		newClient2.setName("Jose");
		newClient2.setPhoneNumber("000-000-0000");

		var created = clientService.addClient(newClient);
		clientService.addAddress(created.getId(), newAddress);
		clientService.addClient(newClient2);
	}

}
