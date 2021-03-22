package com.vtspp.api.ionic.service.impl;

import com.vtspp.api.ionic.domain.ItemOrder;
import com.vtspp.api.ionic.dto.CategoryDTO;
import com.vtspp.api.ionic.repositories.ItemOrderRepository;
import com.vtspp.api.ionic.service.ItemOrderService;
import com.vtspp.api.ionic.service.exceptions.item_order.*;
import com.vtspp.api.ionic.util.messages.exceptions.item_order.UtilMessageItemOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemOrderServiceImpl implements ItemOrderService {

    private ItemOrderRepository itemOrderRepository;

    private UtilMessageItemOrder utilMessageItemOrder;

    @Autowired
    public ItemOrderServiceImpl(ItemOrderRepository itemOrderRepository, UtilMessageItemOrder utilMessageItemOrder) {
        this.itemOrderRepository = itemOrderRepository;
        this.utilMessageItemOrder = utilMessageItemOrder;
    }

    @Override
    public ItemOrder save(ItemOrder obj) throws ItemOrderNotSaveException {
        try {
            return itemOrderRepository.save(obj);
        }
        catch (RuntimeException e) {
            throw new ItemOrderNotSaveException(utilMessageItemOrder.getMessageErrorSaveItemOrder());
        }
    }

    @Override
    public void remove(Integer id) throws ItemOrderRemoveException {
        try {
            itemOrderRepository.deleteById(id);
        }
        catch (RuntimeException e) {
            throw new ItemOrderRemoveException(utilMessageItemOrder.getMessageErrorRemoveItemOrder());
        }
    }

    @Override
    public List<ItemOrder> findAll() throws ItemOrderFindAllException {
        try {
            return itemOrderRepository.findAll();
        }
        catch (RuntimeException e) {
            throw new ItemOrderFindAllException(utilMessageItemOrder.getMessageErrorFindAllItemOrder());
        }
    }

    @Override
    public void update(ItemOrder obj) throws ItemOrderUpdateException, ItemOrderNotFoundException {
        ItemOrder itemOrder;
        try {
            itemOrder = itemOrderRepository.getOne(obj.getId());
            itemOrder.setDiscount(obj.getDiscount());
            itemOrder.setQuantity(obj.getQuantity());
            itemOrder.setPrice(obj.getPrice());
        }
        catch (RuntimeException e) {
            throw new ItemOrderNotFoundException(utilMessageItemOrder.getMessageErrorFindOneItemOrder());
        }
        try {
            itemOrderRepository.save(itemOrder);
        }
        catch (RuntimeException e) {
            throw new ItemOrderUpdateException(utilMessageItemOrder.getMessageErrorUpdateItemOrder());
        }

    }

    @Override
    public CategoryDTO findOne(Integer id) throws RuntimeException {
        return null;
    }
}
