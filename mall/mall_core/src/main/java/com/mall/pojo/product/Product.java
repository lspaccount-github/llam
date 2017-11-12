package com.mall.pojo.product;

import java.io.Serializable;

public class Product implements Serializable {
    /**
     * 商品id
     */
    private String productId;

    /**
     * 商品分类
     */
    private Long classifyId;

    /**
     * 商品状态
     */
    private Integer productStatus;

    /**
     * 商品名称
     */
    private String productName;

    /**
     * 商品描述
     */
    private String productRemark;

    /**
     * 图片路径
     */
    private String pictureUrl;

    /**
     * 商品单位
     */
    private String productUnit;

    /**
     * 最小购买数量
     */
    private Long minBuyNum;

    private static final long serialVersionUID = 1L;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId == null ? null : productId.trim();
    }

    public Long getClassifyId() {
        return classifyId;
    }

    public void setClassifyId(Long classifyId) {
        this.classifyId = classifyId;
    }

    public Integer getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(Integer productStatus) {
        this.productStatus = productStatus;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }

    public String getProductRemark() {
        return productRemark;
    }

    public void setProductRemark(String productRemark) {
        this.productRemark = productRemark == null ? null : productRemark.trim();
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl == null ? null : pictureUrl.trim();
    }

    public String getProductUnit() {
        return productUnit;
    }

    public void setProductUnit(String productUnit) {
        this.productUnit = productUnit == null ? null : productUnit.trim();
    }

    public Long getMinBuyNum() {
        return minBuyNum;
    }

    public void setMinBuyNum(Long minBuyNum) {
        this.minBuyNum = minBuyNum;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", productId=").append(productId);
        sb.append(", classifyId=").append(classifyId);
        sb.append(", productStatus=").append(productStatus);
        sb.append(", productName=").append(productName);
        sb.append(", productRemark=").append(productRemark);
        sb.append(", pictureUrl=").append(pictureUrl);
        sb.append(", productUnit=").append(productUnit);
        sb.append(", minBuyNum=").append(minBuyNum);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}