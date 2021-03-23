package com.vtspp.api.ionic.resource.impl;

import com.vtspp.api.ionic.domain.Telephone;
import com.vtspp.api.ionic.resource.TelephoneResources;
import com.vtspp.api.ionic.service.impl.TelephoneServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/telephones")
public class TelephoneResourcesImpl implements TelephoneResources {

    private TelephoneServiceImpl telephoneService;

    @Autowired
    public TelephoneResourcesImpl(TelephoneServiceImpl telephoneService) {
        this.telephoneService = telephoneService;
    }

    @Override
    public ResponseEntity<Void> save(Telephone obj) {
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(telephoneService.save(obj).getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @Override
    public ResponseEntity<Void> remove(Integer id) {
        telephoneService.remove(id);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<List<Telephone>> findAll() {
        return ResponseEntity.ok(telephoneService.findAll());
    }

    @Override
    public ResponseEntity<Void> update(Telephone obj) {
        telephoneService.update(obj);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<?> findOne(Integer id) {
        return null;
    }

    @Override
    public ResponseEntity<?> findPage(Integer page, Integer linePerPage, String direction, String orderBy) {
        Page<Telephone> telephoneList = telephoneService.findPage(page, linePerPage, direction, orderBy);
        return ResponseEntity.ok(telephoneList);
    }


}
