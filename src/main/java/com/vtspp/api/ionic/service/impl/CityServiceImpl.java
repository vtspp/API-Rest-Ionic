package com.vtspp.api.ionic.service.impl;

import com.vtspp.api.ionic.domain.City;
import com.vtspp.api.ionic.domain.State;
import com.vtspp.api.ionic.facade.FacadeRepository;
import com.vtspp.api.ionic.service.CityService;
import com.vtspp.api.ionic.service.exceptions.city.*;
import com.vtspp.api.ionic.util.messages.exceptions.city.UtilMessageCity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.vtspp.api.ionic.util.Check.isNull;

@Service
public class CityServiceImpl implements CityService {

    private FacadeRepository facadeRepository;

    private UtilMessageCity utilMessageCity;

    @Autowired
    public CityServiceImpl(FacadeRepository facadeRepository, UtilMessageCity utilMessageCity) {
        this.facadeRepository = facadeRepository;
        this.utilMessageCity = utilMessageCity;
    }

    @Override
    public City save(City obj) throws CityNotSaveException {
        try {
            State state = facadeRepository.getStateRepository().save(obj.getState());
            obj.setState(state);
            return facadeRepository.getCityRepository().save(obj);
        }
        catch (RuntimeException e) {
            throw new CityNotSaveException(utilMessageCity.getMessageErrorSaveCity());
        }
    }

    @Override
    public void remove(Integer id) throws CityRemoveException {
        try {
            facadeRepository.getCityRepository().deleteById(id);
        }
        catch (RuntimeException e) {
            throw new CityRemoveException(utilMessageCity.getMessageErrorRemoveCity());
        }
    }

    @Override
    public List<City> findAll() throws CityFindAllException {
        try {
            return facadeRepository.getCityRepository().findAll();
        }
        catch (RuntimeException e) {
            throw new CityFindAllException(utilMessageCity.getMessageErrorFindAllCity());
        }
    }

    @Override
    public void update(City obj) throws CityUpdateException, CityNotFoundException {
        City city;
        try {
            city = facadeRepository.getCityRepository().getOne(obj.getId());
        }
        catch (RuntimeException e) {
            throw new CityNotFoundException(utilMessageCity.getMessageErrorFindOneCity());
        }
        try {
            city.setName(obj.getName());
            city.setState(obj.getState());
            facadeRepository.getCityRepository().save(city);

            State state = obj.getState();
            state.getCities().add(city);
            facadeRepository.getStateRepository().save(state);
        }
        catch (RuntimeException e) {
            throw new CityUpdateException(utilMessageCity.getMessageErrorUpdateCity());
        }

    }

    @Override
    public City findOne(Integer id) throws RuntimeException {
        if(isNull(id)) throw new IllegalArgumentException(utilMessageCity.getMessageErrorFindOneCity());
        return facadeRepository.getCityRepository().getOne(id);
    }

    @Override
    public Page<City> findPage(Integer page, Integer linePerPage, String direction, String orderBy) {
        PageRequest pageRequest = PageRequest.of(page, linePerPage, Sort.Direction.valueOf(direction), orderBy);
        return facadeRepository.getCityRepository().findAll(pageRequest);
    }

    public final UtilMessageCity getUtilMessageCity() {
        return utilMessageCity;
    }
}
