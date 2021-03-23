package com.vtspp.api.ionic.resource.impl;

import com.vtspp.api.ionic.domain.Andress;
import com.vtspp.api.ionic.resource.AndressResources;
import com.vtspp.api.ionic.service.exceptions.andress.AndressNotFoundException;
import com.vtspp.api.ionic.service.impl.AndressServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.persistence.EntityNotFoundException;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/andresses")
public class AndressResourcesImpl implements AndressResources {

    private AndressServiceImpl andressService;

    @Autowired
    public AndressResourcesImpl(AndressServiceImpl andressService) {
        this.andressService = andressService;
    }

    @Override
    public ResponseEntity<Void> save(Andress obj) {
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(andressService.save(obj).getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @Override
    public ResponseEntity<Void> remove(Integer id) {
        andressService.remove(id);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<List<Andress>> findAll() {
        return ResponseEntity.ok(andressService.findAll());
    }

    @Override
    public ResponseEntity<Void> update(Andress obj) {
        andressService.update(obj);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<?> findOne(Integer id) {
        try {
            return ResponseEntity.ok(andressService.findOne(id));
        }
        catch (EntityNotFoundException e) {
            throw new AndressNotFoundException(andressService.getUtilMessageAndress().getMessageErrorFindOneAndress());
        }
    }

    @Override
    public ResponseEntity<?> findPage(Integer page, Integer linePerPage, String direction, String orderBy) {
        Page<Andress> andressesList = andressService.findPage(page, linePerPage, direction, orderBy);
        return ResponseEntity.ok(andressesList);
    }


}
