package com.vtspp.api.ionic.dto;

import com.vtspp.api.ionic.domain.Order;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

public class OrderDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private LocalDateTime instant;

    public OrderDTO(Order order) {
        this.instant = order.getInstant();
    }

    public LocalDateTime getInstant() {
        return instant;
    }

    public void setInstant(LocalDateTime instant) {
        this.instant = instant;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderDTO)) return false;
        OrderDTO orderDTO = (OrderDTO) o;
        return getInstant().equals(orderDTO.getInstant());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getInstant());
    }
}
