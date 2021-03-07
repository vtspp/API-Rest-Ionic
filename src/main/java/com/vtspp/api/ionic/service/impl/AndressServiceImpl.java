package com.vtspp.api.ionic.service.impl;

import com.vtspp.api.ionic.domain.Andress;
import com.vtspp.api.ionic.repositories.AndressRepository;
import com.vtspp.api.ionic.service.AndressService;
import com.vtspp.api.ionic.service.exceptions.Andress.*;
import com.vtspp.api.ionic.util.messages.exceptions.andress.UtilMessageAndress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AndressServiceImpl implements AndressService {

    private AndressRepository andressRepository;

    @Autowired
    public AndressServiceImpl(AndressRepository andressRepository) {
        this.andressRepository = andressRepository;
    }

    @Override
    public Andress save(Andress obj) throws AndressNotSaveException {
        try {
            return andressRepository.save(obj);
        }
        catch (AndressNotSaveException e) {
            throw new AndressNotSaveException(UtilMessageAndress.getMessageErrorSaveAndress());
        }
    }

    @Override
    public void remove(Integer id) throws AndressRemoveException {
        try {
            andressRepository.deleteById(id);
        }
        catch (AndressRemoveException e) {
            throw new AndressRemoveException(UtilMessageAndress.getMessageErrorRemoveAndress());
        }
    }

    @Override
    public List<Andress> findAll() throws AndressFindAllException {
        try {
            return andressRepository.findAll();
        }
        catch (AndressFindAllException e) {
            throw new AndressFindAllException(UtilMessageAndress.getMessageErrorFindAllAndress());
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
        catch (AndressNotFoundException e) {
            throw new AndressNotFoundException(UtilMessageAndress.getMessageErrorFindOneAndress());
        }
        try {
            andressRepository.save(andress);
        }
        catch (AndressUpdateException e) {
            throw new AndressUpdateException(UtilMessageAndress.getMessageErrorUpdateAndress());
        }

    }
}
