package com.peachy.ppp.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.*;

@Entity
@Table(name = "users")
public class UserEntity {
    @Id
    @Type(type = "uuid-char")
    @GeneratedValue(generator = "UUID")
    @Column(name = "uuid", updatable = false, nullable = false)
    private UUID id;

    @NotBlank
    @Size(max = 150)
    private String name;

    @NotBlank
    @Size(max = 150)
    private String email;

    @JsonIgnore
    @NotBlank
    @Size(max = 65)
    private String password;

    @NotBlank
    @Size(max = 50)
    private String user_role;

    @NotBlank
    @Size(max = 60)
    private String business_role;

    @JsonIgnore
    @OneToMany(mappedBy = "targetUser", cascade = CascadeType.ALL)
    List<LoginTimeEntity> last_login;

    @JsonIgnore
    @OneToMany(mappedBy = "targetUser")
    List<OrderEntity> orders = new ArrayList<>();

    @ManyToOne
    private CompanyEntity targetCompany;

    @ManyToOne
    private TeamEntity targetTeam;

    @ManyToOne
    private SubscriptionPlanEntity targetSubscriptionPlan;

    @OneToOne(mappedBy = "targetUser")
    private UserBudgetEntity budget;

    @JsonIgnore
    @ManyToMany(mappedBy = "targetUser", cascade = CascadeType.ALL)
    private List<UserModuleEntity> modules = new ArrayList<>();

    @NotBlank
    @Size(max = 50)
    private String updatedat;
    //todo fix this maby date instead
    @NotBlank
    @Size(max = 50)
    private String createdat;

    public UserBudgetEntity getBudget() {
        return budget;
    }

    public void setBudget(UserBudgetEntity budget) {
        this.budget = budget;
    }

    public List<UserModuleEntity> getModules() {
        return modules;
    }

    public void setModules(List<UserModuleEntity> modules) {
        this.modules = modules;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUser_role() {
        return user_role;
    }

    public void setUser_role(String user_role) {
        this.user_role = user_role;
    }

    public String getBusiness_role() {
        return business_role;
    }

    public void setBusiness_role(String business_role) {
        this.business_role = business_role;
    }

    public CompanyEntity getTargetCompany() {
        return targetCompany;
    }

    public void setTargetCompany(CompanyEntity userEntity) {
        this.targetCompany = userEntity;
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

    public TeamEntity getTargetTeam() {
        return targetTeam;
    }

    public void setTargetTeam(TeamEntity targetTeam) {
        this.targetTeam = targetTeam;
    }

    public List<LoginTimeEntity> getLast_login() {
        return last_login;
    }

    public void setLast_login(List<LoginTimeEntity> last_login) {
        this.last_login = last_login;
    }

    public SubscriptionPlanEntity getTargetSubscriptionPlan() {
        return targetSubscriptionPlan;
    }

    public void setTargetSubscriptionPlan(SubscriptionPlanEntity targetSubscriptionPlan) {
        this.targetSubscriptionPlan = targetSubscriptionPlan;
    }

    //todo fjern tostring

    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", user_role='" + user_role + '\'' +
                ", business_role='" + business_role + '\'' +
                ", last_login=" + last_login +
                ", orders=" + orders +
                ", targetCompany=" + targetCompany +
                ", targetTeam=" + targetTeam +
                ", targetSubscriptionPlan=" + targetSubscriptionPlan +
                ", budget=" + budget +
                ", modules=" + modules +
                ", updatedat='" + updatedat + '\'' +
                ", createdat='" + createdat + '\'' +
                '}';
    }
}
