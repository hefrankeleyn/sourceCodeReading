package com.hef.domain;

/**
 * @Date 2022/5/10
 * @Author lifei
 */
public class ProductItem {
    private Long piId;
    private String productName;
    private String productVersion;

    public ProductItem(){}
    private ProductItem(Builder builder){
        this.piId = builder.piId;
        this.productName = builder.productName;
        this.productVersion = builder.productVersion;
    }

    public static class Builder {
        private Long piId;
        private String productName;
        private String productVersion;

        public Builder piId(Long piId) {this.piId = piId; return this;}
        public Builder productName(String productName) {this.productName = productName; return this;}
        public Builder productVersion(String productVersion) {this.productVersion = productVersion; return this;}

        public ProductItem builder() {
            return new ProductItem(this);
        }
    }

    public Long getPiId() {
        return piId;
    }

    public void setPiId(Long piId) {
        this.piId = piId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductVersion() {
        return productVersion;
    }

    public void setProductVersion(String productVersion) {
        this.productVersion = productVersion;
    }

    @Override
    public String toString() {
        return "ProductItem{" +
                "piId=" + piId +
                ", productName='" + productName + '\'' +
                ", productVersion='" + productVersion + '\'' +
                '}';
    }
}
