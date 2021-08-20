package com.peachy.ppp.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "subscription_plans")
public class SubscriptionPlanEntity {
    @Id
    @Type(type = "uuid-char")
    @GeneratedValue(generator = "UUID")
    @Column(name = "uuid", updatable = false, nullable = false)
    private UUID id;

    @NotBlank
    String name;

    @NotNull
    Integer monthly_price;

    @JsonIgnore
    @OneToMany(mappedBy = "targetSubscriptionPlan", cascade = {CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST})
    private List<UserEntity> user;

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

    public Integer getMonthly_price() {
        return monthly_price;
    }

    public void setMonthly_price(Integer monthly_price) {
        this.monthly_price = monthly_price;
    }

    public List<UserEntity> getUser() {
        return user;
    }

    public void setUser(List<UserEntity> user) {
        this.user = user;
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

    @Override
    public String toString() {
        return "SubscriptionPlanEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", monthly_price=" + monthly_price +
                ", user=" + user +
                ", updatedat='" + updatedat + '\'' +
                ", createdat='" + createdat + '\'' +
                '}';
    }
}
