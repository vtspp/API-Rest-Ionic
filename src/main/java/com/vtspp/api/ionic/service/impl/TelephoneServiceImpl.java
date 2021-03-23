package com.vtspp.api.ionic.service.impl;

import com.vtspp.api.ionic.domain.Telephone;
import com.vtspp.api.ionic.repositories.TelephoneRepository;
import com.vtspp.api.ionic.service.TelephoneService;
import com.vtspp.api.ionic.service.exceptions.telephone.*;
import com.vtspp.api.ionic.util.messages.exceptions.telephone.UtilMessageTelephone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TelephoneServiceImpl implements TelephoneService {

    private TelephoneRepository telephoneRepository;

    private  UtilMessageTelephone utilMessageTelephone;

    @Autowired
    public TelephoneServiceImpl(TelephoneRepository telephoneRepository, UtilMessageTelephone utilMessageTelephone) {
        this.telephoneRepository = telephoneRepository;
        this.utilMessageTelephone = utilMessageTelephone;
    }

    @Override
    public Telephone save(Telephone obj) throws TelephoneNotSaveException {
        try {
            return telephoneRepository.save(obj);
        }
        catch (RuntimeException e) {
            throw new TelephoneNotSaveException(utilMessageTelephone.getMessageErrorSaveTelephone());
        }
    }

    @Override
    public void remove(Integer id) throws TelephoneRemoveException {
        try {
            telephoneRepository.deleteById(id);
        }
        catch (RuntimeException e) {
            throw new TelephoneRemoveException(utilMessageTelephone.getMessageErrorRemoveTelephone());
        }
    }

    @Override
    public List<Telephone> findAll() throws TelephoneFindAllException {
        try {
            return telephoneRepository.findAll();
        }
        catch (RuntimeException e) {
            throw new TelephoneFindAllException(utilMessageTelephone.getMessageErrorFindAllTelephone());
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
            throw new TelephoneNotFoundException(utilMessageTelephone.getMessageErrorFindOneTelephone());
        }
        try {
            telephoneRepository.save(telephone);
        }
        catch (RuntimeException e) {
            throw new TelephoneUpdateException(utilMessageTelephone.getMessageErrorUpdateTelephone());
        }

    }

    @Override
    public Telephone findOne(Integer id) throws RuntimeException {
        return null;
    }

    @Override
    public Page<Telephone> findPage(Integer page, Integer linePerPage, String direction, String orderBy) {
        return null;
    }


}
