package com.vtspp.api.ionic.service.impl;

import com.vtspp.api.ionic.domain.Category;
import com.vtspp.api.ionic.repositories.CategoryRepository;
import com.vtspp.api.ionic.service.CategoryService;
import com.vtspp.api.ionic.service.exceptions.category.*;
import com.vtspp.api.ionic.util.messages.exceptions.category.UtilMessageCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServiceImpl implements CategoryService {

    private CategoryRepository categoryRepository;

    @Autowired
    public CityServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category save(Category obj) throws CategoryNotSaveException {
        try {
            return categoryRepository.save(obj);
        }
        catch (CategoryNotSaveException e) {
            throw new CategoryNotSaveException(UtilMessageCategory.getMessageErrorSaveCategory());
        }
    }

    @Override
    public void remove(Integer id) throws CategoryRemoveException {
        try {
            categoryRepository.deleteById(id);
        }
        catch (CategoryRemoveException e) {
            throw new CategoryRemoveException(UtilMessageCategory.getMessageErrorRemoveCategory());
        }
    }

    @Override
    public List<Category> findAll() throws CategoryFindAllException {
        try {
            return categoryRepository.findAll();
        }
        catch (CategoryFindAllException e) {
            throw new CategoryFindAllException(UtilMessageCategory.getMessageErrorFindAllCategory());
        }
    }

    @Override
    public void update(Category obj) throws CategoryUpdateException, CategoryNotFoundException {
        Category category;
        try {
            category = categoryRepository.getOne(obj.getId());
            category.setName(obj.getName());
        }
        catch (CategoryNotFoundException e) {
            throw new CategoryNotFoundException(UtilMessageCategory.getMessageErrorFindOneCategory());
        }
        try {
            categoryRepository.save(category);
        }
        catch (CategoryUpdateException e) {
            throw new CategoryUpdateException(UtilMessageCategory.getMessageErrorUpdateCategory());
        }

    }
}
