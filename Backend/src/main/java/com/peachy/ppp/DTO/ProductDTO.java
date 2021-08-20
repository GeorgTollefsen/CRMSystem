package com.peachy.ppp.DTO;

public class ProductDTO {

    private String name;

    private Integer seller_comission;

    private Integer comission;

    private String type;

    private boolean monthly_subscription;

    private Integer price;

    private String product_vendor;

    private String companyID;

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isMonthly_subscription() {
        return monthly_subscription;
    }

    public void setMonthly_subscription(boolean monthly_subscription) {
        this.monthly_subscription = monthly_subscription;
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

    public String getCompanyID() {
        return companyID;
    }

    public void setCompanyID(String companyID) {
        this.companyID = companyID;
    }


}
