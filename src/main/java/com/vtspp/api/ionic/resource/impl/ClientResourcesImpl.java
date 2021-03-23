package com.vtspp.api.ionic.resource.impl;

import com.vtspp.api.ionic.domain.Client;
import com.vtspp.api.ionic.dto.ClientDTO;
import com.vtspp.api.ionic.resource.ClientResources;
import com.vtspp.api.ionic.service.exceptions.client.ClientNotFoundException;
import com.vtspp.api.ionic.service.impl.ClientServiceImpl;
import com.vtspp.api.ionic.util.messages.exceptions.client.UtilMessageClient;
import org.apache.logging.log4j.CloseableThreadContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.persistence.EntityNotFoundException;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientResourcesImpl implements ClientResources {

    private ClientServiceImpl clientService;

    @Autowired
    public ClientResourcesImpl(ClientServiceImpl clientService) {
        this.clientService = clientService;
    }

    @Override
    public ResponseEntity<Void> save(Client obj) {
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(clientService.save(obj).getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @Override
    public ResponseEntity<Void> remove(Integer id) {
        clientService.remove(id);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<List<Client>> findAll() {
        return ResponseEntity.ok(clientService.findAll());
    }

    @Override
    public ResponseEntity<Void> update(Client obj) {
        clientService.update(obj);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<?> findOne(Integer id) {
        try {
            return ResponseEntity.ok(new ClientDTO(clientService.findOne(id)));
        }
        catch (EntityNotFoundException e) {
            throw new ClientNotFoundException(clientService.getUtilMessageClient().getMessageErrorFindOneClient());
        }
    }

    @Override
    public ResponseEntity<?> findPage(Integer page, Integer linePerPage, String direction, String orderBy) {
        Page<Client> clientList = clientService.findPage(page, linePerPage, direction, orderBy);
        return ResponseEntity.ok(clientList);
    }


}
