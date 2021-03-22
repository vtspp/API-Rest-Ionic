package com.vtspp.api.ionic.service.impl;

import com.vtspp.api.ionic.domain.State;
import com.vtspp.api.ionic.dto.CategoryDTO;
import com.vtspp.api.ionic.repositories.StateRepository;
import com.vtspp.api.ionic.service.StateService;
import com.vtspp.api.ionic.service.exceptions.state.*;
import com.vtspp.api.ionic.util.messages.exceptions.state.UtilMessageState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StateServiceImpl implements StateService {

    private StateRepository stateRepository;

    private UtilMessageState utilMessageState;

    @Autowired
    public StateServiceImpl(StateRepository stateRepository, UtilMessageState utilMessageState) {
        this.stateRepository = stateRepository;
        this.utilMessageState = utilMessageState;
    }

    @Override
    public State save(State obj) throws StateNotSaveException {
        try {
            return stateRepository.save(obj);
        }
        catch (RuntimeException e) {
            throw new StateNotSaveException(utilMessageState.getMessageErrorSaveState());
        }
    }

    @Override
    public void remove(Integer id) throws StateRemoveException {
        try {
            stateRepository.deleteById(id);
        }
        catch (RuntimeException e) {
            throw new StateRemoveException(utilMessageState.getMessageErrorRemoveState());
        }
    }

    @Override
    public List<State> findAll() throws StateFindAllException {
        try {
            return stateRepository.findAll();
        }
        catch (RuntimeException e) {
            throw new StateFindAllException(utilMessageState.getMessageErrorFindAllState());
        }
    }

    @Override
    public void update(State obj) throws StateUpdateException, StateNotFoundException {
        State state;
        try {
            state = stateRepository.getOne(obj.getId());
            state.setName(obj.getName());
        }
        catch (RuntimeException e) {
            throw new StateNotFoundException(utilMessageState.getMessageErrorFindOneState());
        }
        try {
            stateRepository.save(state);
        }
        catch (RuntimeException e) {
            throw new StateUpdateException(utilMessageState.getMessageErrorUpdateState());
        }

    }

    @Override
    public CategoryDTO findOne(Integer id) throws RuntimeException {
        return null;
    }
}
