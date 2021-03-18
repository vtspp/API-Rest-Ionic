package com.vtspp.api.ionic.repositories;

import com.vtspp.api.ionic.domain.ItemOrder;
import com.vtspp.api.ionic.domain.ItemOrderPK;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemOrderRepository extends Repositories<ItemOrder, ItemOrderPK> {
    void deleteById(Integer id);
}
