package com.vtspp.api.ionic.service.impl;

import com.vtspp.api.ionic.domain.Category;
import com.vtspp.api.ionic.domain.Product;
import com.vtspp.api.ionic.facade.FacadeRepository;
import com.vtspp.api.ionic.service.CategoryService;
import com.vtspp.api.ionic.service.exceptions.category.*;
import com.vtspp.api.ionic.util.messages.exceptions.category.UtilMessageCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.vtspp.api.ionic.util.Check.isNull;

@Service
public class CategoryServiceImpl implements CategoryService {

    private FacadeRepository facadeRepository;

    private UtilMessageCategory utilMessageCategory;

    @Autowired
    public CategoryServiceImpl(FacadeRepository facadeRepository, UtilMessageCategory utilMessageCategory) {
        this.facadeRepository = facadeRepository;
        this.utilMessageCategory = utilMessageCategory;
    }

    @Override
    public Category save(Category obj) throws CategoryNotSaveException {
        try {
            List<Product> products = obj.getProducts();
            facadeRepository.getProductRepository().saveAll(products);
            obj.getProducts().addAll(products);
            return facadeRepository.getCategoryRepository().saveAndFlush(obj);
        }
        catch (RuntimeException e) {
            throw new CategoryNotSaveException(utilMessageCategory.getMessageErrorSaveCategory());
        }
    }

    @Override
    public void remove(Integer id) throws CategoryRemoveException {
        try {
            facadeRepository.getCategoryRepository().deleteById(id);
        }
        catch (RuntimeException e) {
            throw new CategoryRemoveException(utilMessageCategory.getMessageErrorRemoveCategory());
        }
    }

    @Override
    public List<Category> findAll() throws CategoryFindAllException {
        try {
            return facadeRepository.getCategoryRepository().findAll();
        }
        catch (RuntimeException e) {
            throw new CategoryFindAllException(utilMessageCategory.getMessageErrorFindAllCategory());
        }
    }

    @Override
    public void update(Category obj) throws CategoryUpdateException, CategoryNotFoundException {
        Category category;
        try {
            category = facadeRepository.getCategoryRepository().getOne(obj.getId());
        }
        catch (RuntimeException e) {
            throw new CategoryNotFoundException(utilMessageCategory.getMessageErrorFindOneCategory());
        }
        try {
            category.setName(obj.getName());
            category.getProducts().addAll( obj.getProducts());
            facadeRepository.getCategoryRepository().saveAndFlush(category);

            List<Product> productList = category.getProducts();
            productList.stream().forEach(product -> product.setCategory(category));
            facadeRepository.getProductRepository().saveAll(productList);
        }
        catch (RuntimeException e) {
            throw new CategoryUpdateException(utilMessageCategory.getMessageErrorUpdateCategory());
        }

    }

    @Override
    public Category findOne(Integer id) throws RuntimeException {
        if(isNull(id)) throw new IllegalArgumentException(utilMessageCategory.getMessageErrorFindOneCategory());
            return facadeRepository.getCategoryRepository().getOne(id);
    }

    @Override
    public Page<Category> findPage(Integer page, Integer linePerPage, String direction, String orderBy) {
        PageRequest pageRequest = PageRequest.of(page, linePerPage, Sort.Direction.valueOf(direction), orderBy);
        return facadeRepository.getCategoryRepository().findAll(pageRequest);
    }

    public final UtilMessageCategory getUtilMessageCategory() {
        return utilMessageCategory;
    }
}
