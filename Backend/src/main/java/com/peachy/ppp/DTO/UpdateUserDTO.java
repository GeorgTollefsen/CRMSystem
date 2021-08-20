package com.peachy.ppp.DTO;

public class UpdateUserDTO {
    public String id;
    public String name;
    public String email;
    public String userRole;
    public String businessRole;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public String getBusinessRole() {
        return businessRole;
    }

    public void setBusinessRole(String businessRole) {
        this.businessRole = businessRole;
    }

    @Override
    public String toString() {
        return "UpdateUserDTO{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", userRole='" + userRole + '\'' +
                ", businessRole='" + businessRole + '\'' +
                '}';
    }
}
