package com.vtspp.api.ionic.service.impl;

import com.vtspp.api.ionic.domain.Client;
import com.vtspp.api.ionic.repositories.ClientRepository;
import com.vtspp.api.ionic.service.ClientService;
import com.vtspp.api.ionic.service.exceptions.client.*;
import com.vtspp.api.ionic.util.messages.exceptions.client.UtilMessageClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    private ClientRepository clientRepository;

    @Autowired
    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public Client save(Client obj) throws ClientNotSaveException {
        try {
            return clientRepository.save(obj);
        }
        catch (RuntimeException e) {
            throw new ClientNotSaveException(UtilMessageClient.getMessageErrorSaveClient());
        }
    }

    @Override
    public void remove(Integer id) throws ClientRemoveException {
        try {
            clientRepository.deleteById(id);
        }
        catch (RuntimeException e) {
            throw new ClientRemoveException(UtilMessageClient.getMessageErrorRemoveClient());
        }
    }

    @Override
    public List<Client> findAll() throws ClientFindAllException {
        try {
            return clientRepository.findAll();
        }
        catch (RuntimeException e) {
            throw new ClientFindAllException(UtilMessageClient.getMessageErrorFindAllClient());
        }
    }

    @Override
    public void update(Client obj) throws ClientUpdateException, ClientNotFoundException {
        Client client;
        try {
            client = clientRepository.getOne(obj.getId());
            client.setName(obj.getName());
            client.setEmail(obj.getEmail());
            client.setCfpOuCnpj(obj.getCfpOuCnpj());
        }
        catch (RuntimeException e) {
            throw new ClientNotFoundException(UtilMessageClient.getMessageErrorFindOneClient());
        }
        try {
            clientRepository.save(client);
        }
        catch (RuntimeException e) {
            throw new ClientUpdateException(UtilMessageClient.getMessageErrorUpdateClient());
        }

    }
}
