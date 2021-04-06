package com.vtspp.api.ionic.service.impl;

import com.vtspp.api.ionic.domain.Order;
import com.vtspp.api.ionic.facade.FacadeRepository;
import com.vtspp.api.ionic.service.OrderService;
import com.vtspp.api.ionic.service.exceptions.order.*;
import com.vtspp.api.ionic.service.templateMethod.TemplateMethodEmailService;
import com.vtspp.api.ionic.util.Parameter;
import com.vtspp.api.ionic.util.messages.exceptions.order.UtilMessageOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


import static com.vtspp.api.ionic.util.Check.isNull;

@Service
public class OrderServiceImpl implements OrderService, TemplateMethodEmailService<Order> {

    private FacadeRepository facadeRepository;
    private UtilMessageOrder utilMessageOrder;
    private Parameter parameter;

    private static final Logger LOG = LoggerFactory.getLogger(OrderServiceImpl.class);

    @Autowired
    public OrderServiceImpl(FacadeRepository facadeRepository, UtilMessageOrder utilMessageOrder, Parameter parameter) {
        this.facadeRepository = facadeRepository;
        this.utilMessageOrder = utilMessageOrder;
        this.parameter = parameter;
    }

    @Override
    public Order save(Order obj) throws OrderNotSaveException {
        try {
            return facadeRepository.getOrderRepository().save(obj);
        }
        catch (RuntimeException e) {
            throw new OrderNotSaveException(utilMessageOrder.getMessageErrorSaveOrder());
        }
    }

    @Override
    public void remove(Integer id) throws OrderRemoveException {
        try {
            facadeRepository.getOrderRepository().deleteById(id);
        }
        catch (RuntimeException e) {
            throw new OrderRemoveException(utilMessageOrder.getMessageErrorRemoveOrder());
        }
    }

    @Override
    public List<Order> findAll() throws OrderFindAllException {
        try {
            return facadeRepository.getOrderRepository().findAll();
        }
        catch (RuntimeException e) {
            throw new OrderFindAllException(utilMessageOrder.getMessageErrorFindAllOrder());
        }
    }

    @Override
    public void update(Order obj) throws OrderUpdateException, OrderNotFoundException {
        Order order;
        try {
            order = facadeRepository.getOrderRepository().getOne(obj.getId());
        }
        catch (RuntimeException e) {
            throw new OrderNotFoundException(utilMessageOrder.getMessageErrorFindOneOrder());
        }
        try {
            order.setInstant(obj.getInstant());
            order.setClient(obj.getClient());
            order.setPayment(obj.getPayment());
            order.setDeliveryAddress(obj.getDeliveryAddress());
            //order.getItens().addAll(obj.getItens());
            this.senderConfirmation(obj);
            facadeRepository.getOrderRepository().save(order);
        }
        catch (RuntimeException e) {
            throw new OrderUpdateException(utilMessageOrder.getMessageErrorUpdateOrder());
        }

    }

    @Override
    public Order findOne(Integer id) throws RuntimeException {
        if(isNull(id)) throw new IllegalArgumentException(utilMessageOrder.getMessageErrorFindOneOrder());
        return facadeRepository.getOrderRepository().getOne(id);
    }

    @Override
    public Page<Order> findPage(Integer page, Integer linePerPage, String direction, String orderBy) {
        PageRequest pageRequest = PageRequest.of(page, linePerPage, Sort.Direction.valueOf(direction), orderBy);
        return facadeRepository.getOrderRepository().findAll(pageRequest);
    }

    @Override
    public SimpleMailMessage prepareSimpleMailMessage(Order obj) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo(obj.getClient().getEmail());
        simpleMailMessage.setFrom(parameter.getValue("default.recipent"));
        simpleMailMessage.setSubject("Confirmação de Pedido: " + obj.getId());
        simpleMailMessage.setSentDate(new Date(System.currentTimeMillis()));

        return simpleMailMessage;
    }

    @Override
    public void senderEmail(SimpleMailMessage message) {
        LOG.info("Simulando envio de email");
        LOG.info(message.toString());
        LOG.info("Email enviado");
    }

    public final UtilMessageOrder getUtilMessageOrder() {
        return utilMessageOrder;
    }

}
