package com.example.demo.controller;

import com.example.demo.model.Client;
import com.example.demo.service.ClientService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/clients")
public class ClientController {
    public ClientService clientService;
    public ClientController(ClientService clientService){
        this.clientService=clientService;
    }

    @GetMapping
    public List<Client> all(){
        return clientService.getAllClients();
    }
    @PostMapping
    public Client create(@RequestBody Client client){
        return clientService.createClient(client);
    }

    @GetMapping("/{id}")
    public Client get(@PathVariable Long id){
        return clientService.getById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Client update(@PathVariable Long id , @RequestBody Client client){
        return  clientService.update(id,client);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
         clientService.delete(id);
    }

}
