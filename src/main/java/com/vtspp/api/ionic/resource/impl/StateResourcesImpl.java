package com.vtspp.api.ionic.resource.impl;

import com.vtspp.api.ionic.domain.State;
import com.vtspp.api.ionic.dto.StateDTO;
import com.vtspp.api.ionic.resource.StateResources;
import com.vtspp.api.ionic.service.exceptions.state.StateNotFoundException;
import com.vtspp.api.ionic.service.impl.StateServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.persistence.EntityNotFoundException;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/states")
public class StateResourcesImpl implements StateResources {

    private StateServiceImpl stateService;

    @Autowired
    public StateResourcesImpl(StateServiceImpl stateService) {
        this.stateService = stateService;
    }

    @Override
    public ResponseEntity<Void> save(State obj) {
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(stateService.save(obj).getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @Override
    public ResponseEntity<Void> remove(Integer id) {
        stateService.remove(id);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<List<State>> findAll() {
        return ResponseEntity.ok(stateService.findAll());
    }

    @Override
    public ResponseEntity<Void> update(State obj) {
        stateService.update(obj);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<?> findOne(Integer id) {
        try {
            return ResponseEntity.ok(new StateDTO(stateService.findOne(id)));
        }
        catch (EntityNotFoundException e) {
            throw new StateNotFoundException(stateService.getUtilMessageState().getMessageErrorFindOneState());
        }
    }

    @Override
    public ResponseEntity<?> findPage(Integer page, Integer linePerPage, String direction, String orderBy) {
        Page<State> stateList = stateService.findPage(page, linePerPage, direction,orderBy);
        return ResponseEntity.ok(stateList);
    }


}
