package com.vtspp.api.ionic.service.impl;

import com.vtspp.api.ionic.domain.Andress;
import com.vtspp.api.ionic.repositories.AndressRepository;
import com.vtspp.api.ionic.service.AndressService;
import com.vtspp.api.ionic.service.exceptions.andress.*;
import com.vtspp.api.ionic.util.messages.exceptions.andress.UtilMessageAndress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AndressServiceImpl implements AndressService {

    private AndressRepository andressRepository;

    private UtilMessageAndress utilMessageAndress;

    @Autowired
    public AndressServiceImpl(AndressRepository andressRepository, UtilMessageAndress utilMessageAndress) {
        this.andressRepository = andressRepository;
        this.utilMessageAndress = utilMessageAndress;
    }

    @Override
    public Andress save(Andress obj) throws AndressNotSaveException {
        try {
            return andressRepository.save(obj);
        }
        catch (RuntimeException e) {
            throw new AndressNotSaveException(utilMessageAndress.getMessageErrorSaveAndress());
        }
    }

    @Override
    public void remove(Integer id) throws AndressRemoveException {
        try {
            andressRepository.deleteById(id);
        }
        catch (RuntimeException e) {
            throw new AndressRemoveException(utilMessageAndress.getMessageErrorRemoveAndress());
        }
    }

    @Override
    public List<Andress> findAll() throws AndressFindAllException {
        try {
            return andressRepository.findAll();
        }
        catch (RuntimeException e) {
            throw new AndressFindAllException(utilMessageAndress.getMessageErrorFindAllAndress());
        }
    }

    @Override
    public void update(Andress obj) throws AndressUpdateException, AndressNotFoundException {
        Andress andress;
        try {
            andress = andressRepository.getOne(obj.getId());
            andress.setStreet(obj.getStreet());
            andress.setNumber(obj.getNumber());
            andress.setComplement(obj.getComplement());
            andress.setDistrict(obj.getDistrict());
            andress.setZipCode(obj.getZipCode());
            andress.setClient(obj.getClient());
            andress.setCity(obj.getCity());
        }
        catch (RuntimeException e) {
            throw new AndressNotFoundException(utilMessageAndress.getMessageErrorFindOneAndress());
        }
        try {
            andressRepository.save(andress);
        }
        catch (RuntimeException e) {
            throw new AndressUpdateException(utilMessageAndress.getMessageErrorUpdateAndress());
        }

    }

    @Override
    public Andress findOne(Integer id) throws RuntimeException {
        return null;
    }

    @Override
    public Page<Andress> findPage(Integer page, Integer linePerPage, String direction, String orderBy) {
        return null;
    }
}
