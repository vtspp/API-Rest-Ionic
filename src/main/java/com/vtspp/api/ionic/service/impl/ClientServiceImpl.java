package com.vtspp.api.ionic.service.impl;

import com.vtspp.api.ionic.domain.Client;
import com.vtspp.api.ionic.repositories.ClientRepository;
import com.vtspp.api.ionic.service.ClientService;
import com.vtspp.api.ionic.service.exceptions.client.*;
import com.vtspp.api.ionic.util.messages.exceptions.client.UtilMessageClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    private ClientRepository clientRepository;

    private UtilMessageClient utilMessageClient;

    @Autowired
    public ClientServiceImpl(ClientRepository clientRepository, UtilMessageClient utilMessageClient) {
        this.clientRepository = clientRepository;
        this.utilMessageClient = utilMessageClient;
    }

    @Override
    public Client save(Client obj) throws ClientNotSaveException {
        try {
            return clientRepository.save(obj);
        }
        catch (RuntimeException e) {
            throw new ClientNotSaveException(utilMessageClient.getMessageErrorSaveClient());
        }
    }

    @Override
    public void remove(Integer id) throws ClientRemoveException {
        try {
            clientRepository.deleteById(id);
        }
        catch (RuntimeException e) {
            throw new ClientRemoveException(utilMessageClient.getMessageErrorRemoveClient());
        }
    }

    @Override
    public List<Client> findAll() throws ClientFindAllException {
        try {
            return clientRepository.findAll();
        }
        catch (RuntimeException e) {
            throw new ClientFindAllException(utilMessageClient.getMessageErrorFindAllClient());
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
            throw new ClientNotFoundException(utilMessageClient.getMessageErrorFindOneClient());
        }
        try {
            clientRepository.save(client);
        }
        catch (RuntimeException e) {
            throw new ClientUpdateException(utilMessageClient.getMessageErrorUpdateClient());
        }

    }

    @Override
    public Client findOne(Integer id) throws RuntimeException {
        return null;
    }

    @Override
    public Page<Client> findPage(Integer page, Integer linePerPage, String orderBy, String direction) {
        return null;
    }
}
