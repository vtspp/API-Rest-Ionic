package com.vtspp.api.ionic.service.impl;

import com.vtspp.api.ionic.domain.*;
import com.vtspp.api.ionic.enums.TypeClient;
import com.vtspp.api.ionic.facade.FacadeRepository;
import com.vtspp.api.ionic.repositories.ClientRepository;
import com.vtspp.api.ionic.service.ClientService;
import com.vtspp.api.ionic.service.exceptions.client.*;
import com.vtspp.api.ionic.util.messages.exceptions.client.UtilMessageClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static com.vtspp.api.ionic.util.Check.isNull;

@Service
public class ClientServiceImpl implements ClientService {

    private FacadeRepository facadeRepository;

    private UtilMessageClient utilMessageClient;

    @Autowired
    public ClientServiceImpl(FacadeRepository facadeRepository, UtilMessageClient utilMessageClient) {
        this.facadeRepository = facadeRepository;
        this.utilMessageClient = utilMessageClient;
    }

    @Override
    public Client save(Client obj) throws ClientNotSaveException {
        try {
            if(!obj.getAndresses().isEmpty()){
                List<Andress> andresses = new ArrayList<>();
                obj.getAndresses().forEach(andress -> andresses.add(andress));

                List<City> cities = obj.getAndresses().stream().map(Andress::getCity).collect(Collectors.toList());
                List<State> states = obj.getAndresses().stream().map(andress -> andress.getCity().getState()).collect(Collectors.toList());

                if(!cities.isEmpty()){
                    obj.getAndresses().forEach(andress -> facadeRepository.getCityRepository().save(andress.getCity()));
                }
                else if (!states.isEmpty())
                    obj.getAndresses().forEach(andress -> facadeRepository.getStateRepository().save(andress.getCity().getState()));

                andresses.forEach(andress -> andress.setClient(obj));
                facadeRepository.getClientRepository().save(obj);

                facadeRepository.getAndressRepository().saveAll(andresses);
                obj.getAndresses().addAll(andresses);
            }

            if(!obj.getTelephones().isEmpty()){
                Set<Telephone> telephones = new HashSet<>();
                obj.getTelephones().forEach(telephone -> telephones.add(telephone));
                telephones.forEach(telephone -> telephone.setClient(obj));
                facadeRepository.getTelephoneRepository().saveAll(telephones);
                obj.getTelephones().addAll(telephones);
            }

            return facadeRepository.getClientRepository().save(obj);
        }
        catch (RuntimeException e) {
            throw new ClientNotSaveException(utilMessageClient.getMessageErrorSaveClient());
        }
    }

    @Override
    public void remove(Integer id) throws ClientRemoveException {
        try {
            facadeRepository.getClientRepository().deleteById(id);
        }
        catch (RuntimeException e) {
            throw new ClientRemoveException(utilMessageClient.getMessageErrorRemoveClient());
        }
    }

    @Override
    public List<Client> findAll() throws ClientFindAllException {
        try {
            return facadeRepository.getClientRepository().findAll();
        }
        catch (RuntimeException e) {
            throw new ClientFindAllException(utilMessageClient.getMessageErrorFindAllClient());
        }
    }

    @Override
    public void update(Client obj) throws ClientUpdateException, ClientNotFoundException {
        Client client;
        try {
            client = facadeRepository.getClientRepository().getOne(obj.getId());
        }
        catch (RuntimeException e) {
            throw new ClientNotFoundException(utilMessageClient.getMessageErrorFindOneClient());
        }
        try {
            client.setName(obj.getName());
            client.setEmail(obj.getEmail());
            client.setCfpOuCnpj(obj.getCfpOuCnpj());

            switch (obj.getTypeClient()){
                case "Pessoa Juridíca":
                    client.setTypeClient(1);
                    break;
                case "Pessoa Fisíca":
                    client.setTypeClient(0);
                    break;
                default:
                    throw new IllegalArgumentException("O tipo de entidade pública não existe");
            }
            save(client);
        }
        catch (RuntimeException e) {
            throw new ClientUpdateException(utilMessageClient.getMessageErrorUpdateClient());
        }

    }

    @Override
    public Client findOne(Integer id) throws IllegalArgumentException {
        if(isNull(id)) throw new IllegalArgumentException(utilMessageClient.getMessageErrorFindOneClient());
            return facadeRepository.getClientRepository().getOne(id);
    }

    @Override
    public Page<Client> findPage(Integer page, Integer linePerPage, String direction, String orderBy) {
        PageRequest pageRequest = PageRequest.of(page, linePerPage, Sort.Direction.valueOf(direction), orderBy);
        return facadeRepository.getClientRepository().findAll(pageRequest);
    }

    public final UtilMessageClient getUtilMessageClient() {
        return utilMessageClient;
    }
}
