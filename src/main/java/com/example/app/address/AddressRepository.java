package com.example.app.address;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.app.client.Client;

@Repository
public interface AddressRepository extends JpaRepository<Client, Long> {

}
