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

    private UtilMessageCity utilMessageCity;

    @Autowired
    public CityServiceImpl(CityRepository cityRepository, UtilMessageCity utilMessageCity) {
        this.cityRepository = cityRepository;
        this.utilMessageCity = utilMessageCity;
    }

    @Override
    public City save(City obj) throws CityNotSaveException {
        try {
            return cityRepository.save(obj);
        }
        catch (RuntimeException e) {
            throw new CityNotSaveException(utilMessageCity.getMessageErrorSaveCity());
        }
    }

    @Override
    public void remove(Integer id) throws CityRemoveException {
        try {
            cityRepository.deleteById(id);
        }
        catch (RuntimeException e) {
            throw new CityRemoveException(utilMessageCity.getMessageErrorRemoveCity());
        }
    }

    @Override
    public List<City> findAll() throws CityFindAllException {
        try {
            return cityRepository.findAll();
        }
        catch (RuntimeException e) {
            throw new CityFindAllException(utilMessageCity.getMessageErrorFindAllCity());
        }
    }

    @Override
    public void update(City obj) throws CityUpdateException, CityNotFoundException {
        City city;
        try {
            city = cityRepository.getOne(obj.getId());
            city.setName(obj.getName());
        }
        catch (RuntimeException e) {
            throw new CityNotFoundException(utilMessageCity.getMessageErrorFindOneCity());
        }
        try {
            cityRepository.save(city);
        }
        catch (RuntimeException e) {
            throw new CityUpdateException(utilMessageCity.getMessageErrorUpdateCity());
        }

    }
}
