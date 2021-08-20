package com.peachy.ppp.DTO;

public class UserDTO {

    private String name;

    private String email;

    private String password;

    private String user_role;

    private String business_role;

    private String companyID;

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

    public String getCompanyID() {
        return companyID;
    }

    public void setCompanyID(String companyID) {
        this.companyID = companyID;
    }
}
