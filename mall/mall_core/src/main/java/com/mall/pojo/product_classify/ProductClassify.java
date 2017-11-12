package com.mall.pojo.product_classify;

import java.io.Serializable;

public class ProductClassify implements Serializable {
    /**
     * 商品分类id
     */
    private Long classifyId;

    /**
     * 商户id
     */
    private String merchantId;

    /**
     * 分类名称
     */
    private String classifyName;

    /**
     * 是否有效(1:有效,0:无效)
     */
    private Integer isValid;

    private static final long serialVersionUID = 1L;

    public Long getClassifyId() {
        return classifyId;
    }

    public void setClassifyId(Long classifyId) {
        this.classifyId = classifyId;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId == null ? null : merchantId.trim();
    }

    public String getClassifyName() {
        return classifyName;
    }

    public void setClassifyName(String classifyName) {
        this.classifyName = classifyName == null ? null : classifyName.trim();
    }

    public Integer getIsValid() {
        return isValid;
    }

    public void setIsValid(Integer isValid) {
        this.isValid = isValid;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", classifyId=").append(classifyId);
        sb.append(", merchantId=").append(merchantId);
        sb.append(", classifyName=").append(classifyName);
        sb.append(", isValid=").append(isValid);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}