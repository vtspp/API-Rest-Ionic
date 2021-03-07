package com.vtspp.api.ionic.service.impl;

import com.vtspp.api.ionic.domain.City;
import com.vtspp.api.ionic.repositories.CityRepository;
import com.vtspp.api.ionic.service.CityService;
import com.vtspp.api.ionic.service.exceptions.city.*;
import com.vtspp.api.ionic.util.messages.exceptions.city.UtilMessageCity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServiceImpl implements CityService {

    private CityRepository cityRepository;

    @Autowired
    public CityServiceImpl(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Override
    public City save(City obj) throws CityNotSaveException {
        try {
            return cityRepository.save(obj);
        }
        catch (CityNotSaveException e) {
            throw new CityNotSaveException(UtilMessageCity.getMessageErrorSaveCity());
        }
    }

    @Override
    public void remove(Integer id) throws CityRemoveException {
        try {
            cityRepository.deleteById(id);
        }
        catch (CityRemoveException e) {
            throw new CityRemoveException(UtilMessageCity.getMessageErrorRemoveCity());
        }
    }

    @Override
    public List<City> findAll() throws CityFindAllException {
        try {
            return cityRepository.findAll();
        }
        catch (CityFindAllException e) {
            throw new CityFindAllException(UtilMessageCity.getMessageErrorFindAllCity());
        }
    }

    @Override
    public void update(City obj) throws CityUpdateException, CityNotFoundException {
        City city;
        try {
            city = cityRepository.getOne(obj.getId());
            city.setName(obj.getName());
        }
        catch (CityNotFoundException e) {
            throw new CityNotFoundException(UtilMessageCity.getMessageErrorFindOneCity());
        }
        try {
            cityRepository.save(city);
        }
        catch (CityUpdateException e) {
            throw new CityUpdateException(UtilMessageCity.getMessageErrorUpdateCity());
        }

    }
}
