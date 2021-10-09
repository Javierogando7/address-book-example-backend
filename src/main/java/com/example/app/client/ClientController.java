package com.example.app.client;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.app.address.Address;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/client")
public class ClientController {
	
	private IClientService clientService;

	@Autowired
	public ClientController(IClientService clientService) {
		this.clientService = clientService;
	}

	@GetMapping()
	public List<Client> getAllClients() {
		return clientService.getAllClients();
	}

	@PostMapping()
	public void createClient(@RequestBody Client newClient) {
		clientService.addClient(newClient);
	}

	@PutMapping("{clientId}")
	public void updateClient(@PathVariable("clientId") Long clientId, @RequestBody Client client) {
		clientService.updateClient(clientId, client);
	}

	@DeleteMapping("{clientId}")
	public void deleteClient(@PathVariable("clientId") Long clientId) {
		clientService.deleteClient(clientId);
	}

	@PostMapping("{clientId}/address")
	public void addAddress(@PathVariable("clientId") Long clientId, @RequestBody Address address) {
		clientService.addAddress(clientId, address);
	}

	@DeleteMapping("{clientId}/address/{addressId}")
	public void addAddress(@PathVariable("clientId") Long clientId, @PathVariable("clientId") Long addressId) {
		clientService.deleteAddress(clientId, addressId);
	}
}
