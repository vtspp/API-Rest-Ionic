package com.vtspp.api.ionic.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity(name = "tb_product")
public class Product implements Serializable {
    private static final long serialVersionUID = 1L;

     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Double price;

    @ManyToMany
    @JoinTable(name = "tb_product_category", joinColumns =
    @JoinColumn(name = "product_id"), inverseJoinColumns = @JoinColumn(name = "category_id"))
    private List<Category> categories  =  new ArrayList<>();

    @OneToMany(mappedBy = "id.product")
    private List<ItemOrder> itens = new ArrayList<>();

    public Product () {
    }

    public Product(Integer id, String name, Double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public List<ItemOrder> getItens() {
        return itens;
    }

    public List<Order> getOrders() {
        List<Order> orderList = new ArrayList<>();

        for (ItemOrder itemOrder : itens){
            orderList.add(itemOrder.getOrder());
        }

        return orderList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id.equals(product.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
