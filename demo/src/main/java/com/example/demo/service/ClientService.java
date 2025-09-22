package com.example.demo.service;


import com.example.demo.model.Client;
import com.example.demo.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    public ClientRepository clientRepository;
    public ClientService(ClientRepository clientRepository){
        this.clientRepository=clientRepository;
    }

    public List<Client> getAllClients(){
        return clientRepository.findAll();
    }


    public Client createClient(Client client){
        return clientRepository.save(client);
    }


    public Optional<Client> getById(Long id){
        return clientRepository.findById(id);
    }

    public void delete(Long id){
        clientRepository.deleteById(id);
    }

    public Client update(Long id , Client client){
        return clientRepository.findById(id).map(c->{
            c.setEmail(client.getEmail());
            c.setNom(client.getNom());
            return clientRepository.save(c);
        }).orElse(null);
    }

}
