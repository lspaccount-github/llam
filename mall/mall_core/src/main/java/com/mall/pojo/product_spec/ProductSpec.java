package com.mall.pojo.product_spec;

import java.io.Serializable;
import java.math.BigDecimal;

public class ProductSpec implements Serializable {
    /**
     * 规格id
     */
    private Long spceId;

    /**
     * 规格名称
     */
    private String spceName;

    /**
     * 价格
     */
    private BigDecimal price;

    /**
     * 餐盒费
     */
    private BigDecimal lunchFee;

    /**
     * 当前库存
     */
    private Long currentInventory;

    /**
     * 最大库存
     */
    private Long maxInventory;

    /**
     * 商品id
     */
    private String productId;

    private static final long serialVersionUID = 1L;

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

    public BigDecimal getLunchFee() {
        return lunchFee;
    }

    public void setLunchFee(BigDecimal lunchFee) {
        this.lunchFee = lunchFee;
    }

    public Long getCurrentInventory() {
        return currentInventory;
    }

    public void setCurrentInventory(Long currentInventory) {
        this.currentInventory = currentInventory;
    }

    public Long getMaxInventory() {
        return maxInventory;
    }

    public void setMaxInventory(Long maxInventory) {
        this.maxInventory = maxInventory;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId == null ? null : productId.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", spceId=").append(spceId);
        sb.append(", spceName=").append(spceName);
        sb.append(", price=").append(price);
        sb.append(", lunchFee=").append(lunchFee);
        sb.append(", currentInventory=").append(currentInventory);
        sb.append(", maxInventory=").append(maxInventory);
        sb.append(", productId=").append(productId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}