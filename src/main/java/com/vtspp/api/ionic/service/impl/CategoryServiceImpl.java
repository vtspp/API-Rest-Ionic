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
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository categoryRepository;

    private UtilMessageCategory utilMessageCategory;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository, UtilMessageCategory utilMessageCategory) {
        this.categoryRepository = categoryRepository;
        this.utilMessageCategory = utilMessageCategory;
    }

    @Override
    public Category save(Category obj) throws CategoryNotSaveException {
        try {
            return categoryRepository.save(obj);
        }
        catch (RuntimeException e) {
            throw new CategoryNotSaveException(utilMessageCategory.getMessageErrorSaveCategory());
        }
    }

    @Override
    public void remove(Integer id) throws CategoryRemoveException {
        try {
            categoryRepository.deleteById(id);
        }
        catch (RuntimeException e) {
            throw new CategoryRemoveException(utilMessageCategory.getMessageErrorRemoveCategory());
        }
    }

    @Override
    public List<Category> findAll() throws CategoryFindAllException {
        try {
            return categoryRepository.findAll();
        }
        catch (RuntimeException e) {
            throw new CategoryFindAllException(utilMessageCategory.getMessageErrorFindAllCategory());
        }
    }

    @Override
    public void update(Category obj) throws CategoryUpdateException, CategoryNotFoundException {
        Category category;
        try {
            category = categoryRepository.getOne(obj.getId());
            category.setName(obj.getName());
        }
        catch (RuntimeException e) {
            throw new CategoryNotFoundException(utilMessageCategory.getMessageErrorFindOneCategory());
        }
        try {
            categoryRepository.save(category);
        }
        catch (RuntimeException e) {
            throw new CategoryUpdateException(utilMessageCategory.getMessageErrorUpdateCategory());
        }

    }
}
