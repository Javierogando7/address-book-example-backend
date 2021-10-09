package com.example.app.client;

import java.util.List;

import com.example.app.address.Address;

public interface IClientService {

	public List<Client> getAllClients();

	public Client getClientById(Long id);

	public Client addClient(Client clientToAdd);

	public Client updateClient(Long id, Client updatedClient);

	public void deleteClient(Long id);

	public boolean clientExistsById(Long id);
	
	public void addAddress(Long clientId, Address address);
	
	public void deleteAddress(Long clientId, Long addressId);
}
