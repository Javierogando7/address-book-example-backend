package com.example.app.client;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.app.address.Address;

@Service
public class ClientServiceImpl implements IClientService {
	private final ClientRepository clientRepo;

	@Autowired
	public ClientServiceImpl(ClientRepository clientRepo) {
		this.clientRepo = clientRepo;
	}

	public List<Client> getAllClients() {
		return clientRepo.findAll();
	}

	public Client getClientById(Long id) {
		return clientRepo.getById(id);
	}

	public Client addClient(Client clientToAdd) {
		return clientRepo.save(clientToAdd);
	}

	public Client updateClient(Long id, Client updatedClient) {
		var clientToUpdate = getClientById(id);
		clientToUpdate.setName(updatedClient.getName());
		clientToUpdate.setPhoneNumber(updatedClient.getPhoneNumber());
		return clientRepo.save(clientToUpdate);
	}

	public void deleteClient(Long id) {
		clientRepo.deleteById(id);
	}
	
	public void addAddress(Long clientId, Address address) {
		var clientToUpdate = getClientById(clientId);
		clientToUpdate.getAddresses().add(address);
	}
	
	public void deleteAddress(Long clientId, Long addressId) {
		var clientToUpdate = getClientById(clientId);
		clientToUpdate.getAddresses().removeIf(a -> a.getId() == addressId);
	}
	
	public boolean clientExistsById(Long id) {
		return clientRepo.existsById(id);
	}
}
