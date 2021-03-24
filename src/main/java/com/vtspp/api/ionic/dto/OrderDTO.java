package com.vtspp.api.ionic.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.vtspp.api.ionic.domain.ItemOrder;
import com.vtspp.api.ionic.domain.Order;
import com.vtspp.api.ionic.domain.Telephone;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.*;

public class OrderDTO implements Serializable {
    private static final long serialVersionUID = 1L;


    private String client;
    private String email;
    private String cfpOuCnpj;
    private Set<Telephone> telephone;
    private String typeClient;
    private String street;
    private Integer number;
    private String complement;
    private String district;
    private String zipCode;
    private String city;
    private String state;
    private LocalDateTime instant;
    private String statusPayment;
    private List<ItemOrder> itens;


    public OrderDTO(Order order) {
        this.client = order.getClient().getName();
        this.email = order.getClient().getEmail();
        this.cfpOuCnpj = order.getClient().getCfpOuCnpj();
        this.telephone = order.getClient().getTelephones();
        this.typeClient = order.getClient().getTypeClient();
        this.street = order.getDeliveryAddress().getStreet();
        this.number = order.getDeliveryAddress().getNumber();
        this.complement = order.getDeliveryAddress().getComplement();
        this.district = order.getDeliveryAddress().getDistrict();
        this.zipCode = order.getDeliveryAddress().getZipCode();
        this.city = order.getDeliveryAddress().getCity().getName();
        this.state = order.getDeliveryAddress().getCity().getState().getName();
        this.instant = order.getInstant();
        this.statusPayment = order.getPayment().getStatus();
        this.itens = order.getItens();
    }

    public String getClient() {
        return client;
    }

    public String getEmail() {
        return email;
    }

    public String getCfpOuCnpj() {
        return cfpOuCnpj;
    }

    public String getTelephone() {
        Set<String> set = new HashSet<>();
        telephone.forEach(x -> set.add(x.getNumber()));
        return set.toString().replace("[", "").replace("]", "");
    }

    public String getTypeClient() {
        return typeClient;
    }

    public String getStreet() {
        return street;
    }

    public Integer getNumber() {
        return number;
    }

    public String getComplement() {
        return complement;
    }

    public String getDistrict() {
        return district;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    public LocalDateTime getInstant() {
        return instant;
    }

    public String getStatusPayment() {
        return statusPayment;
    }

    public List<ItemOrder> getItens() {
        return itens;
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
