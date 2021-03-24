package com.vtspp.api.ionic.dto;

import com.vtspp.api.ionic.domain.ItemOrder;

import java.io.Serializable;
import java.util.Objects;

public class ItemOrderDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer orderNumber;
    private Double discount;
    private Integer quantity;
    private Double price;
    private Double subTotal;

    public ItemOrderDTO(ItemOrder itemOrder) {
        this.orderNumber = itemOrder.getOrder().getId();
        this.discount = itemOrder.getDiscount();
        this.quantity = itemOrder.getQuantity();
        this.price = itemOrder.getPrice();
        this.subTotal = itemOrder.getSubTotal();
    }

    public Integer getOrderNumber() {
        return orderNumber;
    }

    public Double getDiscount() {
        return discount;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Double getPrice() {
        return price;
    }

    public Double getSubTotal() {
        return subTotal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ItemOrderDTO)) return false;
        ItemOrderDTO that = (ItemOrderDTO) o;
        return getOrderNumber().equals(that.getOrderNumber()) &&
                getDiscount().equals(that.getDiscount()) &&
                getQuantity().equals(that.getQuantity()) &&
                getPrice().equals(that.getPrice()) &&
                getSubTotal().equals(that.getSubTotal());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getOrderNumber(), getDiscount(), getQuantity(), getPrice(), getSubTotal());
    }
}
