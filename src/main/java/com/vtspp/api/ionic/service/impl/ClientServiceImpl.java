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
        catch (ClientNotSaveException e) {
            throw new ClientNotSaveException(UtilMessageClient.getMessageErrorSaveClient());
        }
    }

    @Override
    public void remove(Integer id) throws ClientRemoveException {
        try {
            clientRepository.deleteById(id);
        }
        catch (ClientRemoveException e) {
            throw new ClientRemoveException(UtilMessageClient.getMessageErrorRemoveClient());
        }
    }

    @Override
    public List<Client> findAll() throws ClientFindAllException {
        try {
            return clientRepository.findAll();
        }
        catch (ClientFindAllException e) {
            throw new ClientFindAllException(UtilMessageClient.getMessageErrorFindAllClient());
        }
    }

    @Override
    public void update(Client obj) throws ClientUpdateException, ClientNotFoundException {
        Client client;
        try {
            client = clientRepository.getOne(obj.getId());
            client.setName(obj.getName());
        }
        catch (ClientNotFoundException e) {
            throw new ClientNotFoundException(UtilMessageClient.getMessageErrorFindOneClient());
        }
        try {
            clientRepository.save(client);
        }
        catch (ClientUpdateException e) {
            throw new ClientUpdateException(UtilMessageClient.getMessageErrorUpdateClient());
        }

    }
}
