package com.peachy.ppp.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "companies")
public class CompanyEntity {
    @Id
    @Type(type = "uuid-char")
    @GeneratedValue(generator = "UUID")
    @Column(name = "uuid", updatable = false, nullable = false)
    private UUID id;

    @NotBlank
    @Size(max = 100)
    private String name;

    @NotBlank
    @Size(max = 20)
    private String company_id;

    @NotBlank
    @Size(max = 255)
    private String street;

    @NotBlank
    @Size(max = 8)
    private String postal_code;

    @NotBlank
    @Size(max = 255)
    private String city;

    @NotBlank
    @Size(max = 255)
    private String company_contact;

    @NotBlank
    @Size(max = 15)
    private String phone;

    @OneToOne(mappedBy = "targetCompany")
    private CompanyBudgetEntity budget;

    @JsonIgnore
    @OneToMany(mappedBy = "targetCompany", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<UserEntity> user;

    @OneToMany(mappedBy = "targetCompany", cascade = CascadeType.ALL)
    private List<ProductEntity> products;

    @OneToMany(mappedBy = "targetCompany", cascade = CascadeType.ALL)
    private List<TeamEntity> teams;

    @NotBlank
    @Size(max = 100)
    private String email;

    @Size(max = 35)
    @NotBlank
    private String updatedat;


    @NotBlank
    @Size(max = 35)
    private String createdat;

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany_id() {
        return company_id;
    }

    public void setCompany_id(String company_id) {
        this.company_id = company_id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPostal_code() {
        return postal_code;
    }

    public void setPostal_code(String postal_code) {
        this.postal_code = postal_code;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCompany_contact() {
        return company_contact;
    }

    public void setCompany_contact(String company_contact) {
        this.company_contact = company_contact;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public List<UserEntity> getUser() {
        return user;
    }

    public void setUser(List<UserEntity> user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "CompanyEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", company_id='" + company_id + '\'' +
                ", street='" + street + '\'' +
                ", postal_code='" + postal_code + '\'' +
                ", city='" + city + '\'' +
                ", company_contact='" + company_contact + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", updatedat='" + updatedat + '\'' +
                ", createdat='" + createdat + '\'' +
                '}';
    }
}
