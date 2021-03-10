package com.vtspp.api.ionic.service.impl;

import com.vtspp.api.ionic.domain.Telephone;
import com.vtspp.api.ionic.repositories.TelephoneRepository;
import com.vtspp.api.ionic.service.TelephoneService;
import com.vtspp.api.ionic.service.exceptions.telephone.*;
import com.vtspp.api.ionic.util.messages.exceptions.telephone.UtilMessageTelephone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TelephoneServiceImpl implements TelephoneService {

    private TelephoneRepository telephoneRepository;

    @Autowired
    public TelephoneServiceImpl(TelephoneRepository telephoneRepository) {
        this.telephoneRepository = telephoneRepository;
    }

    @Override
    public Telephone save(Telephone obj) throws TelephoneNotSaveException {
        try {
            return telephoneRepository.save(obj);
        }
        catch (RuntimeException e) {
            throw new TelephoneNotSaveException(UtilMessageTelephone.getMessageErrorSaveTelephone());
        }
    }

    @Override
    public void remove(Integer id) throws TelephoneRemoveException {
        try {
            telephoneRepository.deleteById(id);
        }
        catch (RuntimeException e) {
            throw new TelephoneRemoveException(UtilMessageTelephone.getMessageErrorRemoveTelephone());
        }
    }

    @Override
    public List<Telephone> findAll() throws TelephoneFindAllException {
        try {
            return telephoneRepository.findAll();
        }
        catch (RuntimeException e) {
            throw new TelephoneFindAllException(UtilMessageTelephone.getMessageErrorFindAllTelephone());
        }
    }

    @Override
    public void update(Telephone obj) throws TelephoneUpdateException, TelephoneNotFoundException {
        Telephone telephone;
        try {
            telephone = telephoneRepository.getOne(obj.getId());
            telephone.setNumber(obj.getNumber());
        }
        catch (RuntimeException e) {
            throw new TelephoneNotFoundException(UtilMessageTelephone.getMessageErrorFindOneTelephone());
        }
        try {
            telephoneRepository.save(telephone);
        }
        catch (RuntimeException e) {
            throw new TelephoneUpdateException(UtilMessageTelephone.getMessageErrorUpdateTelephone());
        }

    }
}
