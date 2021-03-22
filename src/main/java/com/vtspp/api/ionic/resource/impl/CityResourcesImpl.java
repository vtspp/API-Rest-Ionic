package com.vtspp.api.ionic.resource.impl;

import com.vtspp.api.ionic.domain.City;
import com.vtspp.api.ionic.resource.CityResources;
import com.vtspp.api.ionic.service.impl.CityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/cities")
public class CityResourcesImpl implements CityResources {

    private CityServiceImpl cityService;

    @Autowired
    public CityResourcesImpl(CityServiceImpl cityService) {
        this.cityService = cityService;
    }

    @Override
    public ResponseEntity<Void> save(City obj) {
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(cityService.save(obj).getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @Override
    public ResponseEntity<Void> remove(Integer id) {
        cityService.remove(id);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<List<City>> findAll() {
        return ResponseEntity.ok(cityService.findAll());
    }

    @Override
    public ResponseEntity<Void> update(City obj) {
        cityService.update(obj);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<?> findOne(Integer id) {
        return null;
    }

    @Override
    public ResponseEntity<?> findPage(Integer page, Integer linePerPage, String direction, String orderBy) {
        return null;
    }


}
