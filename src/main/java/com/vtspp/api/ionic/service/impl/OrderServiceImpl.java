package com.vtspp.api.ionic.service.impl;

import com.vtspp.api.ionic.domain.Order;
import com.vtspp.api.ionic.repositories.OrderRepository;
import com.vtspp.api.ionic.service.OrderService;
import com.vtspp.api.ionic.service.exceptions.order.*;
import com.vtspp.api.ionic.util.messages.exceptions.order.UtilMessageOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Order save(Order obj) throws OrderNotSaveException {
        try {
            return orderRepository.save(obj);
        }
        catch (RuntimeException e) {
            throw new OrderNotSaveException(UtilMessageOrder.getMessageErrorSaveOrder());
        }
    }

    @Override
    public void remove(Integer id) throws OrderRemoveException {
        try {
            orderRepository.deleteById(id);
        }
        catch (RuntimeException e) {
            throw new OrderRemoveException(UtilMessageOrder.getMessageErrorRemoveOrder());
        }
    }

    @Override
    public List<Order> findAll() throws OrderFindAllException {
        try {
            return orderRepository.findAll();
        }
        catch (RuntimeException e) {
            throw new OrderFindAllException(UtilMessageOrder.getMessageErrorFindAllOrder());
        }
    }

    @Override
    public void update(Order obj) throws OrderUpdateException, OrderNotFoundException {
        Order order;
        try {
            order = orderRepository.getOne(obj.getId());
            order.setInstant(obj.getInstant());
            order.setClient(obj.getClient());
            order.setPayment(obj.getPayment());
            order.setDeliveryAddress(obj.getDeliveryAddress());
        }
        catch (RuntimeException e) {
            throw new OrderNotFoundException(UtilMessageOrder.getMessageErrorFindOneOrder());
        }
        try {
            orderRepository.save(order);
        }
        catch (RuntimeException e) {
            throw new OrderUpdateException(UtilMessageOrder.getMessageErrorUpdateOrder());
        }

    }
}
