package com.vtspp.api.ionic.resource.impl;

import com.vtspp.api.ionic.domain.State;
import com.vtspp.api.ionic.resource.StateResources;
import com.vtspp.api.ionic.service.impl.StateServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/state")
public class StateResourcesImpl implements StateResources {

    private StateServiceImpl stateService;

    @Autowired
    public StateResourcesImpl(StateServiceImpl stateService) {
        this.stateService = stateService;
    }

    @PostMapping
    @Override
    public ResponseEntity<Void> save(@RequestBody State obj) {
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(stateService.save(obj).getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity<Void> remove(@PathVariable Integer id) {
        stateService.remove(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    @Override
    public ResponseEntity<List<State>> findAll() {
        return ResponseEntity.ok(stateService.findAll());
    }

    @PutMapping
    @Override
    public ResponseEntity<Void> update(@RequestBody State obj) {
        stateService.update(obj);
        return ResponseEntity.ok().build();
    }
}
