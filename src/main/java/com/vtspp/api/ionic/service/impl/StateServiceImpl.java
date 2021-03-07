package com.vtspp.api.ionic.service.impl;

import com.vtspp.api.ionic.domain.State;
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

    @Autowired
    public StateServiceImpl(StateRepository stateRepository) {
        this.stateRepository = stateRepository;
    }

    @Override
    public State save(State obj) throws StateNotSaveException {
        try {
            return stateRepository.save(obj);
        }
        catch (StateNotSaveException e) {
            throw new StateNotSaveException(UtilMessageState.getMessageErrorSaveState());
        }
    }

    @Override
    public void remove(Integer id) throws StateRemoveException {
        try {
            stateRepository.deleteById(id);
        }
        catch (StateRemoveException e) {
            throw new StateRemoveException(UtilMessageState.getMessageErrorRemoveState());
        }
    }

    @Override
    public List<State> findAll() throws StateFindAllException {
        try {
            return stateRepository.findAll();
        }
        catch (StateFindAllException e) {
            throw new StateFindAllException(UtilMessageState.getMessageErrorFindAllState());
        }
    }

    @Override
    public void update(State obj) throws StateUpdateException, StateNotFoundException {
        State state;
        try {
            state = stateRepository.getOne(obj.getId());
            state.setName(obj.getName());
        }
        catch (StateNotFoundException e) {
            throw new StateNotFoundException(UtilMessageState.getMessageErrorFindOneState());
        }
        try {
            stateRepository.save(state);
        }
        catch (StateUpdateException e) {
            throw new StateUpdateException(UtilMessageState.getMessageErrorUpdateState());
        }

    }
}
