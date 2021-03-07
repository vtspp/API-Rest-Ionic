package com.vtspp.api.ionic.service.impl;

import com.vtspp.api.ionic.domain.Product;
import com.vtspp.api.ionic.repositories.ProductRepository;
import com.vtspp.api.ionic.service.ProductService;
import com.vtspp.api.ionic.service.exceptions.product.ProductNotFoundException;
import com.vtspp.api.ionic.service.exceptions.product.ProductNotSaveException;
import com.vtspp.api.ionic.service.exceptions.product.ProductRemoveException;
import com.vtspp.api.ionic.util.messages.exceptions.product.UtilMessageProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl (ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product save(Product obj) throws ProductNotSaveException {
        try {
            return productRepository.save(obj);
        }
        catch (ProductNotSaveException e) {
            throw new ProductNotSaveException(UtilMessageProduct.getMessageErrorSaveProduct());
        }
    }

    @Override
    public void remove(Integer id) throws ProductRemoveException {
        try {
            productRepository.deleteById(id);
        }
        catch (ProductNotFoundException e) {
            throw new ProductNotFoundException(UtilMessageProduct.getMessageErrorRemoveProduct());
        }
    }

    @Override
    public List<Product> findAll() throws ProductNotFoundException {
        try {
            return productRepository.findAll();
        }
        catch (ProductNotFoundException e) {
            throw new ProductNotFoundException(UtilMessageProduct.getMessageErrorFindAllProduct());
        }
    }

    @Override
    public void update(Product obj) throws ProductNotFoundException, ProductNotSaveException {
        Product product;
        try {
            product = productRepository.getOne(obj.getId());
            product.setName(obj.getName());
            product.setPrice(obj.getPrice());
        }
        catch (ProductNotFoundException e) {
            throw new ProductNotFoundException(UtilMessageProduct.getMessageErrorFindOneProduct());
        }
        try {
            productRepository.save(product);
        }
        catch (ProductNotSaveException e) {
            throw new ProductNotSaveException(UtilMessageProduct.getMessageErrorUpdateProduct());
        }
    }
}
