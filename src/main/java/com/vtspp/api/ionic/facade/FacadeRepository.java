package com.vtspp.api.ionic.facade;

import com.vtspp.api.ionic.repositories.*;
import org.springframework.stereotype.Component;

@Component
public class FacadeRepository {

    private AndressRepository andressRepository;
    private CategoryRepository categoryRepository;
    private CityRepository cityRepository;
    private ClientRepository clientRepository;
    private ItemOrderRepository itemOrderRepository;
    private OrderRepository orderRepository;
    private ProductRepository productRepository;
    private StateRepository stateRepository;
    private TelephoneRepository telephoneRepository;

    public FacadeRepository(AndressRepository andressRepository, CategoryRepository categoryRepository, CityRepository cityRepository, ClientRepository clientRepository, ItemOrderRepository itemOrderRepository, OrderRepository orderRepository, ProductRepository productRepository, StateRepository stateRepository, TelephoneRepository telephoneRepository) {
        this.andressRepository = andressRepository;
        this.categoryRepository = categoryRepository;
        this.cityRepository = cityRepository;
        this.clientRepository = clientRepository;
        this.itemOrderRepository = itemOrderRepository;
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
        this.stateRepository = stateRepository;
        this.telephoneRepository = telephoneRepository;
    }

    public AndressRepository getAndressRepository() {
        return andressRepository;
    }

    public CategoryRepository getCategoryRepository() {
        return categoryRepository;
    }

    public CityRepository getCityRepository() {
        return cityRepository;
    }

    public ClientRepository getClientRepository() {
        return clientRepository;
    }

    public ItemOrderRepository getItemOrderRepository() {
        return itemOrderRepository;
    }

    public OrderRepository getOrderRepository() {
        return orderRepository;
    }

    public ProductRepository getProductRepository() {
        return productRepository;
    }

    public StateRepository getStateRepository() {
        return stateRepository;
    }

    public TelephoneRepository getTelephoneRepository() {
        return telephoneRepository;
    }
}
