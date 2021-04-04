package com.vtspp.api.ionic.service.impl;

import com.vtspp.api.ionic.domain.Andress;
import com.vtspp.api.ionic.domain.City;
import com.vtspp.api.ionic.domain.State;
import com.vtspp.api.ionic.facade.FacadeRepository;
import com.vtspp.api.ionic.service.AndressService;
import com.vtspp.api.ionic.service.exceptions.andress.*;
import com.vtspp.api.ionic.util.messages.exceptions.andress.UtilMessageAndress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.vtspp.api.ionic.util.Check.isNull;

@Service
public class AndressServiceImpl implements AndressService {

    private FacadeRepository facadeRepository;
    private UtilMessageAndress utilMessageAndress;

    @Autowired
    public AndressServiceImpl(FacadeRepository facadeRepository, UtilMessageAndress utilMessageAndress) {
        this.facadeRepository = facadeRepository;
        this.utilMessageAndress = utilMessageAndress;
    }

    @Override
    public Andress save(Andress obj) throws AndressNotSaveException {
        try {
            State state = facadeRepository.getStateRepository().save(obj.getCity().getState());
            City city = facadeRepository.getCityRepository().save(obj.getCity());
            state.getCities().add(city);

            obj.getCity().setState(state);
            obj.setCity(city);
            return facadeRepository.getAndressRepository().save(obj);
        }
        catch (RuntimeException e) {
            throw new AndressNotSaveException(utilMessageAndress.getMessageErrorSaveAndress());
        }
    }

    @Override
    public void remove(Integer id) throws AndressRemoveException {
        try {
            facadeRepository.getAndressRepository().deleteById(id);
        }
        catch (RuntimeException e) {
            throw new AndressRemoveException(utilMessageAndress.getMessageErrorRemoveAndress());
        }
    }

    @Override
    public List<Andress> findAll() throws AndressFindAllException {
        try {
            return facadeRepository.getAndressRepository().findAll();
        }
        catch (RuntimeException e) {
            throw new AndressFindAllException(utilMessageAndress.getMessageErrorFindAllAndress());
        }
    }

    @Override
    public void update(Andress obj) throws AndressUpdateException, AndressNotFoundException {
        Andress andress;
        try {
            andress = facadeRepository.getAndressRepository().getOne(obj.getId());
            andress.setStreet(obj.getStreet());
            andress.setNumber(obj.getNumber());
            andress.setComplement(obj.getComplement());
            andress.setDistrict(obj.getDistrict());
            andress.setZipCode(obj.getZipCode());
            andress.setCity(obj.getCity());
            andress.getCity().setState(obj.getCity().getState());
        }
        catch (RuntimeException e) {
            throw new AndressNotFoundException(utilMessageAndress.getMessageErrorFindOneAndress());
        }
        try {
            facadeRepository.getAndressRepository().saveAndFlush(andress);
        }
        catch (RuntimeException e) {
            throw new AndressUpdateException(utilMessageAndress.getMessageErrorUpdateAndress());
        }

    }

    @Override
    public Andress findOne(Integer id) throws RuntimeException {
        if(isNull(id)) throw new IllegalArgumentException(utilMessageAndress.getMessageErrorFindOneAndress());
        return facadeRepository.getAndressRepository().getOne(id);
    }

    @Override
    public Page<Andress> findPage(Integer page, Integer linePerPage, String direction, String orderBy) {
        PageRequest pageRequest = PageRequest.of(page, linePerPage, Sort.Direction.valueOf(direction), orderBy);
        return facadeRepository.getAndressRepository().findAll(pageRequest);
    }

    public final UtilMessageAndress getUtilMessageAndress() {
        return utilMessageAndress;
    }
}
