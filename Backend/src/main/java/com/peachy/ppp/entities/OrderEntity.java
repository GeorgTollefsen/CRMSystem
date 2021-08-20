package com.peachy.ppp.entities;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "orders")
public class OrderEntity {
    @Id
    @Type(type = "uuid-char")
    @GeneratedValue(generator = "UUID")
    @Column(name = "uuid", updatable = false, nullable = false)
    private UUID id;

    //todo virker ikke
    @GeneratedValue
    @Column(unique = true)
    Long order_number;

    @ManyToMany(mappedBy = "orders")
    List<ProductEntity> products;

    @ManyToOne
    CustomerEntity targetCustomer;

    @ManyToOne
    UserEntity targetUser;

    @NotBlank
    String updatedat;

    @NotBlank
    String createdat;

    public UUID getId() {
        return id;
    }

    public Long getOrder_number() {
        return order_number;
    }

    public void setOrder_number(Long order_number) {
        this.order_number = order_number;
    }

    public List<ProductEntity> getProducts() {
        return products;
    }

    public void setProducts(List<ProductEntity> products) {
        this.products = products;
    }

    public CustomerEntity getTargetCustomer() {
        return targetCustomer;
    }

    public void setTargetCustomer(CustomerEntity targetCustomer) {
        this.targetCustomer = targetCustomer;
    }

    public UserEntity getTargetUser() {
        return targetUser;
    }

    public void setTargetUser(UserEntity targetUser) {
        this.targetUser = targetUser;
    }

    public String getUpdatedat() {
        return updatedat;
    }

    public void setUpdatedat(String updatedat) {
        this.updatedat = updatedat;
    }

    public String getCreatedat() {
        return createdat;
    }

    public void setCreatedat(String createdat) {
        this.createdat = createdat;
    }
}
