package com.peachy.ppp.entities;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.UUID;

@Entity
@Table(name = "user_budget")
public class UserBudgetEntity {
    @Id
    @Type(type = "uuid-char")
    @GeneratedValue(generator = "UUID")
    @Column(name = "uuid", updatable = false, nullable = false)
    private UUID id;

    @NotNull
    Double daily_budget;

    @NotNull
    Double weekly_budget;

    @NotNull
    Double monthly_budget;

    @NotNull
    Double yearly_budget;

    @NotNull
    @OneToOne
    UserEntity targetUser;

    @Size(max = 35)
    @NotBlank
    private String updatedat;

    @NotBlank
    @Size(max = 35)
    private String createdat;

    public UUID getId() {
        return id;
    }

    public Double getDaily_budget() {
        return daily_budget;
    }

    public void setDaily_budget(Double daily_budget) {
        this.daily_budget = daily_budget;
    }

    public Double getWeekly_budget() {
        return weekly_budget;
    }

    public void setWeekly_budget(Double weekly_budget) {
        this.weekly_budget = weekly_budget;
    }

    public Double getMonthly_budget() {
        return monthly_budget;
    }

    public void setMonthly_budget(Double monthly_budget) {
        this.monthly_budget = monthly_budget;
    }

    public Double getYearly_budget() {
        return yearly_budget;
    }

    public void setYearly_budget(Double yearly_budget) {
        this.yearly_budget = yearly_budget;
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
