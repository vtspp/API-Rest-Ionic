package com.vtspp.api.ionic.resource.impl;

import com.vtspp.api.ionic.domain.Telephone;
import com.vtspp.api.ionic.dto.CategoryDTO;
import com.vtspp.api.ionic.resource.TelephoneResources;
import com.vtspp.api.ionic.service.impl.TelephoneServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
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

    @PostMapping
    @Override
    public ResponseEntity<Void> save(@RequestBody Telephone obj) {
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(telephoneService.save(obj).getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity<Void> remove(@PathVariable Integer id) {
        telephoneService.remove(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    @Override
    public ResponseEntity<List<Telephone>> findAll() {
        return ResponseEntity.ok(telephoneService.findAll());
    }

    @PutMapping
    @Override
    public ResponseEntity<Void> update(@RequestBody Telephone obj) {
        telephoneService.update(obj);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<CategoryDTO> findOne(Integer id) {
        return null;
    }
}
