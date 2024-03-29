package com.vtspp.api.ionic.service.impl;

import com.vtspp.api.ionic.domain.ItemOrder;
import com.vtspp.api.ionic.facade.FacadeRepository;
import com.vtspp.api.ionic.repositories.ItemOrderRepository;
import com.vtspp.api.ionic.service.ItemOrderService;
import com.vtspp.api.ionic.service.exceptions.item_order.*;
import com.vtspp.api.ionic.util.messages.exceptions.item_order.UtilMessageItemOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.vtspp.api.ionic.util.Check.isNull;
import static com.vtspp.api.ionic.util.Converter.toItemOrderPK;

@Service
public class ItemOrderServiceImpl implements ItemOrderService {

    private FacadeRepository facadeRepository;

    private UtilMessageItemOrder utilMessageItemOrder;

    @Autowired
    public ItemOrderServiceImpl(FacadeRepository facadeRepository, UtilMessageItemOrder utilMessageItemOrder) {
        this.facadeRepository = facadeRepository;
        this.utilMessageItemOrder = utilMessageItemOrder;
    }

    @Override
    public ItemOrder save(ItemOrder obj) throws ItemOrderNotSaveException {
        try {
            facadeRepository.getProductRepository().save(obj.getProduct());
            facadeRepository.getOrderRepository().save(obj.getId().getOrder());
            return facadeRepository.getItemOrderRepository().save(obj);
        }
        catch (RuntimeException e) {
            throw new ItemOrderNotSaveException(utilMessageItemOrder.getMessageErrorSaveItemOrder());
        }
    }

    @Override
    public void remove(Integer id) throws ItemOrderRemoveException {
        try {
            facadeRepository.getItemOrderRepository().deleteById(toItemOrderPK(id));
        }
        catch (RuntimeException e) {
            throw new ItemOrderRemoveException(utilMessageItemOrder.getMessageErrorRemoveItemOrder());
        }
    }

    @Override
    public List<ItemOrder> findAll() throws ItemOrderFindAllException {
        try {
            return facadeRepository.getItemOrderRepository().findAll();
        }
        catch (RuntimeException e) {
            throw new ItemOrderFindAllException(utilMessageItemOrder.getMessageErrorFindAllItemOrder());
        }
    }

    @Override
    public void update(ItemOrder obj) throws ItemOrderUpdateException, ItemOrderNotFoundException {
        ItemOrder itemOrder;
        try {
            itemOrder = facadeRepository.getItemOrderRepository().getOne(obj.getId());
            itemOrder.setDiscount(obj.getDiscount());
            itemOrder.setQuantity(obj.getQuantity());
            itemOrder.setPrice(obj.getPrice());
            itemOrder.getId().setOrder(obj.getOrder());
            itemOrder.getId().setProduct(obj.getProduct());
        }
        catch (RuntimeException e) {
            throw new ItemOrderNotFoundException(utilMessageItemOrder.getMessageErrorFindOneItemOrder());
        }
        try {
            facadeRepository.getItemOrderRepository().save(itemOrder);
        }
        catch (RuntimeException e) {
            throw new ItemOrderUpdateException(utilMessageItemOrder.getMessageErrorUpdateItemOrder());
        }

    }

    @Override
    public ItemOrder findOne(Integer id) throws RuntimeException {
        if(isNull(id)) throw new IllegalArgumentException(utilMessageItemOrder.getMessageErrorFindOneItemOrder());
        return facadeRepository.getItemOrderRepository().getOne(toItemOrderPK(id));
    }

    @Override
    public Page<ItemOrder> findPage(Integer page, Integer linePerPage, String direction, String orderBy) {
        PageRequest pageRequest = PageRequest.of(page, linePerPage, Sort.Direction.valueOf(direction), orderBy);
        return facadeRepository.getItemOrderRepository().findAll(pageRequest);
    }

    public final UtilMessageItemOrder getUtilMessageItemOrder() {
        return utilMessageItemOrder;
    }
}
