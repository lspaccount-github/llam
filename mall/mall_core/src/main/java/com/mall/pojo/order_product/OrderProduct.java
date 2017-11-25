package com.mall.pojo.order_product;

import java.io.Serializable;
import java.math.BigDecimal;

public class OrderProduct implements Serializable {
    /**
     * 订单商品id
     */
    private Long orderProductId;

    /**
     * 订单id
     */
    private String orderId;

    /**
     * 商品id
     */
    private String productId;

    /**
     * 商品分类名称
     */
    private String classifyName;

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

    /**
     * 购买商品数量
     */
    private Long buyProductNum;

    /**
     * 规格id
     */
    private Long spceId;

    /**
     * 商品规格名称
     */
    private String spceName;

    /**
     * 价格
     */
    private BigDecimal price;

    private static final long serialVersionUID = 1L;

    public Long getOrderProductId() {
        return orderProductId;
    }

    public void setOrderProductId(Long orderProductId) {
        this.orderProductId = orderProductId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId == null ? null : productId.trim();
    }

    public String getClassifyName() {
        return classifyName;
    }

    public void setClassifyName(String classifyName) {
        this.classifyName = classifyName == null ? null : classifyName.trim();
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

    public Long getBuyProductNum() {
        return buyProductNum;
    }

    public void setBuyProductNum(Long buyProductNum) {
        this.buyProductNum = buyProductNum;
    }

    public Long getSpceId() {
        return spceId;
    }

    public void setSpceId(Long spceId) {
        this.spceId = spceId;
    }

    public String getSpceName() {
        return spceName;
    }

    public void setSpceName(String spceName) {
        this.spceName = spceName == null ? null : spceName.trim();
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", orderProductId=").append(orderProductId);
        sb.append(", orderId=").append(orderId);
        sb.append(", productId=").append(productId);
        sb.append(", classifyName=").append(classifyName);
        sb.append(", productName=").append(productName);
        sb.append(", productRemark=").append(productRemark);
        sb.append(", pictureUrl=").append(pictureUrl);
        sb.append(", productUnit=").append(productUnit);
        sb.append(", minBuyNum=").append(minBuyNum);
        sb.append(", buyProductNum=").append(buyProductNum);
        sb.append(", spceId=").append(spceId);
        sb.append(", spceName=").append(spceName);
        sb.append(", price=").append(price);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
