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

    private UtilMessageProduct utilMessageProduct;

    @Autowired
    public ProductServiceImpl (ProductRepository productRepository, UtilMessageProduct utilMessageProduct) {
        this.productRepository = productRepository;
        this.utilMessageProduct = utilMessageProduct;
    }

    @Override
    public Product save(Product obj) throws ProductNotSaveException {
        try {
            return productRepository.save(obj);
        }
        catch (RuntimeException e) {
            throw new ProductNotSaveException(utilMessageProduct.getMessageErrorSaveProduct());
        }
    }

    @Override
    public void remove(Integer id) throws ProductRemoveException {
        try {
            productRepository.deleteById(id);
        }
        catch (RuntimeException e) {
            throw new ProductNotFoundException(utilMessageProduct.getMessageErrorRemoveProduct());
        }
    }

    @Override
    public List<Product> findAll() throws ProductNotFoundException {
        try {
            return productRepository.findAll();
        }
        catch (RuntimeException e) {
            throw new ProductNotFoundException(utilMessageProduct.getMessageErrorFindAllProduct());
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
        catch (RuntimeException e) {
            throw new ProductNotFoundException(utilMessageProduct.getMessageErrorFindOneProduct());
        }
        try {
            productRepository.save(product);
        }
        catch (RuntimeException e) {
            throw new ProductNotSaveException(utilMessageProduct.getMessageErrorUpdateProduct());
        }
    }
}
