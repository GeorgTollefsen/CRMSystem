package com.peachy.ppp.entities;

import org.hibernate.annotations.Type;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "products")
public class ProductEntity {
    @Id
    @Type(type = "uuid-char")
    @GeneratedValue(generator = "UUID")
    @Column(name = "uuid", updatable = false, nullable = false)
    private UUID id;

    @NotBlank
    String name;

    @NotNull
    Integer seller_comission;

    @NotNull
    Integer comission;

    @NotBlank
    String type;

    @NotNull
    Boolean monthly_subscription;

    @NotNull
    Integer price;

    @NotBlank
    String product_vendor;

    @NotNull
    @ManyToOne
    CompanyEntity targetCompany;

    @ManyToMany
    List<OrderEntity> orders;

    @NotBlank
    String updatedat;

    @NotBlank
    String createdat;

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSeller_comission() {
        return seller_comission;
    }

    public void setSeller_comission(Integer seller_comission) {
        this.seller_comission = seller_comission;
    }

    public Integer getComission() {
        return comission;
    }

    public void setComission(Integer comission) {
        this.comission = comission;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getProduct_vendor() {
        return product_vendor;
    }

    public void setProduct_vendor(String product_vendor) {
        this.product_vendor = product_vendor;
    }

    public CompanyEntity getTargetCompany() {
        return targetCompany;
    }

    public void setTargetCompany(CompanyEntity targetCompany) {
        this.targetCompany = targetCompany;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Boolean getMonthly_subscription() {
        return monthly_subscription;
    }

    public void setMonthly_subscription(Boolean monthly_subscription) {
        this.monthly_subscription = monthly_subscription;
    }
}
