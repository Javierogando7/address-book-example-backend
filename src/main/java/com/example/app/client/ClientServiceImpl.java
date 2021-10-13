package com.example.app.client;

import java.util.*;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.app.address.Address;
import com.example.app.address.AddressRepository;

@Service
public class ClientServiceImpl implements IClientService {
	private final ClientRepository clientRepo;
	private final AddressRepository addressRepo;

	@Autowired
	public ClientServiceImpl(ClientRepository clientRepo, AddressRepository addressRepo) {
		this.clientRepo = clientRepo;
		this.addressRepo = addressRepo;
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
		if (clientExistsById(clientId)) {
			address.setClientId(clientId);
			addressRepo.save(address);
		}
	}

	public void deleteAddress(Long clientId, Long addressId) {
		if (clientExistsById(clientId)) {
			addressRepo.deleteById(addressId);
		}
	}

	public List<Address> getAllAddressFromClient(Long clientId) {
		var allAddresses = addressRepo.findAll();
		var addresses = allAddresses.stream().filter((a) -> {
			return a.getClientId() == clientId;
		}).collect(Collectors.toList());
		return addresses;
	}

	public boolean clientExistsById(Long id) {
		return clientRepo.existsById(id);
	}
}
